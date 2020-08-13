import java.sql.*;

public class FindNonsan {
    /*
    The VerifyACity class is a script that connects to the frodo database at Bentley, and searches the database for the
    city Nonsan. If the city is found, the city's corresponding country code and population are printed, otherwise the
    program exits. The program then uses a prepared statement to find the country name and continent using the country
    code that was take from the initial query.
     */
    public static void main(String[] args) {
        String URL = "jdbc:mysql://frodo.bentley.edu:3306/world";
        String username = "harry";
        String password = "harry";

        // Load MySQL driver into the JVM memory
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Failed to lad MySQL drive.");
            return;
        }

        // Create connection to database that will be used later
        Connection con  = null;

        try {
            con = DriverManager.getConnection (URL, username, password);

            Statement stm = con.createStatement();

            // Search the sql database for the city
            System.out.println("Searching for Nonsan");
            ResultSet result = stm.executeQuery("select * from city where name = 'Nonsan';");
            String countryCode = null;
            int population = 0;

            if (result.next()) {
                System.out.println("City found.");
                countryCode = result.getString("countrycode");
                population = result.getInt("population");
                System.out.println("The countrycode is " + countryCode);
                System.out.println("The population is " + population);
            } else {
                System.out.println("No results found.");
                System.exit(0);
            }
            stm.close();

            // Get the country name and continent of the city.
            System.out.println("Searching for country name and continent.");
            String sql = "select country.name, country.continent from country where country.code = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,countryCode);
            ResultSet result2 = pstm.executeQuery();
            if (result2.next()) {
                System.out.println("Country found.");
                String countryName = result2.getString("name");
                String continent = result2.getString("continent");
                System.out.println("The country name is " + countryName);
                System.out.println("The continent name is " + continent);
            } else {
                System.out.println("No results found.");
                System.exit(0);
            }
            pstm.close();

            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
