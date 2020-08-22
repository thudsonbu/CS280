import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter Something");

        String something = keyboard.next();

        System.out.println(something);
    }
}
