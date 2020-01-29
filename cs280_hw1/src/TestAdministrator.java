import java.util.Scanner;

public class TestAdministrator {
    public static void main(String[] args){


        Date myDate = new Date(1,1,2000);
        Administrator bob = new Administrator("Financial Analyst","Finance", "Joe",
                "Bob", myDate, 50000);

        System.out.println(bob.getTitle());
        System.out.println(bob.getDivision());
        System.out.println(bob.getSupervisor());
        System.out.println(bob.getHireDate());
        System.out.println(bob.getName());
        System.out.println(bob.getSalary());

        Administrator joe = new Administrator( );
        System.out.println(joe.getTitle());
        System.out.println(joe.getDivision());
        System.out.println(joe.getSupervisor());
        System.out.println(joe.getHireDate());
        System.out.println(joe.getName());
        System.out.println(joe.getSalary());


        bob.addAdministratorData();
        System.out.println(bob.toString());



        Administrator admin1 = new Administrator();
        Administrator admin2 = new Administrator();

        System.out.println(admin1.equals(admin2));

        Administrator admin3 = new Administrator("Financial Analyst", "Finance", "Joe Joerson",
                "Burt Burterson", myDate, 100000000);

        System.out.println(admin1.equals(admin3));
    }
}
