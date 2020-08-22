import java.io.IOException;
import java.sql.*;  //import all the JDBC classes

public class MySQLExample {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://frodo.bentley.edu:3306/test";
        String username = "harry";
        String password = "harry";

        try { //load driver into VM memory
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL driver.");
            return;
        }
        Connection con = null;
        try { //create connection and statement objects
            con = DriverManager.getConnection (
                    URL,
                    username,
                    password);
            Statement stmt = con.createStatement();

            // execute SQL commands to create table, insert data, select contents

            stmt.executeUpdate("drop table if exists first;");
            stmt.executeUpdate("create table first(id integer primary key, city varchar(25));");
            stmt.executeUpdate("insert into first values(1, 'Waltham');");
            stmt.executeUpdate("insert into first values(2, 'Cambridge');");
            stmt.executeUpdate("insert into first values(3, 'Somerville');");
            stmt.executeUpdate("insert into first values(4, 'Arlington');");

            ResultSet result = stmt.executeQuery("select * from first;");

            while (result.next()) {
                System.out.printf("%d    %-20s%n", result.getInt("id"), result.getString("city"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally { //close connection if it was opened
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}