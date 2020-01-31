public class TestAdministrator {
    public static void main(String[] args){
        // test standard constructor
        Date myDate = new Date(1,1,2000);
        Administrator bob = new Administrator("Financial Analyst","Finance", "Joe",
                "Bob", myDate, 50000);

        System.out.println(bob.getTitle());
        System.out.println(bob.getDivision());
        System.out.println(bob.getSupervisor());
        System.out.println(bob.getHireDate());
        System.out.println(bob.getName());
        System.out.println(bob.getSalary());

        // test no argument constructor
        Administrator joe = new Administrator( );
        System.out.println(joe.getTitle());
        System.out.println(joe.getDivision());
        System.out.println(joe.getSupervisor());
        System.out.println(joe.getHireDate());
        System.out.println(joe.getName());
        System.out.println(joe.getSalary());

        // test toString method
        bob.addAdministratorData();
        System.out.println(bob.toString());

        // test equals method
        Administrator admin1 = new Administrator();
        Administrator admin2 = new Administrator();
        Employee emp1 = new Employee();

        System.out.println(admin1.equals(admin2));
        System.out.println(admin2.equals(admin1));
        System.out.println(emp1.equals(admin1));
        System.out.println(admin1.equals(emp1));

        Administrator admin3 = new Administrator("Financial Analyst", "Finance", "Joe Johnson",
                "Burt Java", myDate, 100000000);

        System.out.println(admin1.equals(admin3));
        System.out.println(emp1.equals(admin3));

    }
}