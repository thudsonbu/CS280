import java.util.Scanner;

public class Administrator extends SalariedEmployee{

    // INSTANCE VARIABLES

    private String title; // the title of the administrator such as president or director
    private String division; // the area of responsibility such as accounting or production
    private String supervisor; // the immediate supervisor of the administrator

    // CONSTRUCTORS

    public Administrator(String title, String division, String supervisor, String theName, Date theDate,
                         double theSalary) {
        super(theName, theDate, theSalary);
        this.title = title;
        this.division = division;
        this.supervisor = supervisor;
    }

    public Administrator( ){
        super( );
        this.title = "No Title";
        this.division = "No Division";
        this.supervisor = "No Supervisor";
    }

    // ACCESSOR AND MUTATOR METHODS

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    // TOSTRING

    public String toString(){
        return "Name: " + this.getName() + "\n" + "Title: " + this.getTitle() + "\n" + "Division: " + this.getDivision()
                + "\n" + "Supervisor: " + this.getSupervisor() + "\n" + "Salary: " + this.getSalary() + "\n"
                + "Hire Date: " + this.getHireDate();
    }

    // EQUALS

    public boolean equals(Object otherObject) {
        boolean equal = true;
        if (otherObject == null) { // check if null
            equal = false;
        }
        if (otherObject.getClass() != getClass()){ // check if class are equal
            equal = false;
        }
        Administrator admn = (Administrator) otherObject;
        // field comparison
        if (!this.getName().equals(admn.getName())){
            equal = false;
        } else if (!this.getTitle().equals(admn.getTitle())){
            equal = false;
        } else if (!this.getDivision().equals(admn.getDivision())){
            equal = false;
        } else if (!this.getSupervisor().equals(admn.getSupervisor())){
            equal = false;
        } else if (!this.getHireDate().equals(admn.getHireDate())){
            equal = false;
        } else if (this.getSalary() != admn.getSalary()){
            equal = false;
        }
        return equal;
    }

    // READ IN DATA

    public boolean addAdministratorData() {
        // create change made boolean
        Boolean changeMade = true;
        // create scanner
        Scanner keyboard = new Scanner(System.in);
        // read in data
        System.out.println("Please enter the administrators title. ");
        String inputTitle = keyboard.nextLine();
        System.out.println("Please enter the administrators division. ");
        String inputDivision = keyboard.next();
        keyboard.nextLine();
        System.out.println("Please enter the name of the administrators immediate supervisor. ");
        String inputSupervisor = keyboard.nextLine();
        System.out.println("Please enter the employee's name. ");
        String inputName = keyboard.nextLine();
        System.out.println("Please enter the day of hire. (as an integer) ");
        int inputDay = keyboard.nextInt();
        System.out.println("Please enter the month of hire. (As an integer) ");
        int inputMonth = keyboard.nextInt();
        System.out.println("Please enter the year of hire. (As an integer) ");
        int inputYear = keyboard.nextInt();
        System.out.println("Please enter the employee's salary. (as an integer w/o commas) ");
        double inputSalary = keyboard.nextDouble();
        // verify and add data
        if (inputTitle != null){
            setTitle(inputTitle);
        } else {
            changeMade = false;
            System.out.println("Invalid Title");
        }
        if (inputDivision != null){
            setDivision(inputDivision);
        } else {
            changeMade = false;
            System.out.println("Invalid Division");
        }
        if (inputSupervisor != null){
            setSupervisor(inputSupervisor);
        } else {
            changeMade = false;
            System.out.println("Invalid Supervisor");
        }
        if (inputName != null){
            setName(inputName);
        } else {
            changeMade = false;
            System.out.println("Invalid Name");
        }
        if (inputSalary >= 0){
            setSalary(inputSalary);
        } else {
            changeMade = false;
            System.out.println("Invalid Salary");
        }
        Date hireDate = new Date();
        hireDate.setDate(inputMonth,inputDay,inputYear);
        setHireDate(hireDate);
        // return boolean if values set
        return changeMade;
    }
}