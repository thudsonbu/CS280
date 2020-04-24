import java.util.InputMismatchException;
import java.util.Scanner;

public class DateConverter {

    public static boolean checkLeapYear(int year){ // determines if a year is a leap year
        boolean isLeapYear = false;
        if(year % 4 == 0) {
            if(year % 100 == 0){
                if(year % 400 ==0){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }

    public static boolean checkYear(int year){ // checks if valid year
        boolean validYear = false;
        if (year >= 1000 && year <= 3000) {
            validYear = true;
        }
        return validYear;
    }

    public static boolean checkMonth(int month){ // checks if valid month
        boolean validMonth = false;
        if (month >= 1 && month <= 12) {
            validMonth = true;
        }
        return validMonth;
    }

    public static boolean checkDay(int day, int month, int year){ // checks if valid day w/ year and month
        boolean validDay = false;
        int[] daysInMonth = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        if (checkLeapYear(year) && month ==2){
            if (day >= 1 && day <= 29){
                validDay = true;
            }
        } else if (day >= 1 && day <= daysInMonth[month -1]){
            validDay = true;
        }
        return validDay;
    }

    public static void main(String[] args){
        // initiate scanner
        Scanner keyboard = new Scanner(System.in);

        // month key
        String[] monthKey = new String[]{"January","February","March","April","May","June","July","August", "September",
                "October","November","December"};

        // check variables
        boolean validDate = false;

        int month = 0;
        int day = 0;
        int year= 0;

        while (!validDate){
            // try data input (catches mismatched input)
            try {
                // check if year input valid
                try {
                    System.out.println("Enter a valid year: ");
                    int yearEntered = keyboard.nextInt();
                    if (checkYear(yearEntered)) {
                        year = yearEntered;
                    } else {
                        throw new YearException();
                    }
                } catch (YearException e){
                    System.out.println(e);
                    continue;
                }

                // check if month input is valid
                try {
                    System.out.println("Enter a valid month: ");
                    int monthEntered = keyboard.nextInt();
                    if (checkMonth(monthEntered)) {
                        month = monthEntered;
                    } else {
                        throw new MonthException();
                    }
                } catch (MonthException e){
                    System.out.println(e);
                    continue;
                }

                // check if day input is valid
                try {
                    System.out.println("Enter a valid day: ");
                    int dayEntered = keyboard.nextInt();
                    if (checkDay(dayEntered, month, year)) {
                        day = dayEntered;
                        validDate = true;
                    } else {
                        throw new DayException();
                    }
                } catch (DayException e){
                    System.out.println(e);
                    continue;
                }

            } catch (InputMismatchException a){
                System.out.println("Input Type Error");
                keyboard.next();
            }
        }
        keyboard.close();
        // output the converted date
        System.out.println(monthKey[month-1] + " " + day + ", " + year);
    }
}
