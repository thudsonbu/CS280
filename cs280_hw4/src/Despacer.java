import java.io.*;
import java.util.Scanner;

public class Despacer {
    public static void main(String[] args){

        // Generate a unique temporary file name and create temporary file output stream
        String fileName = "temporaryfile";
        PrintWriter tmpOutputStream = null; // initiate a outputStream for temporary file usable by method
        Scanner userInputStream = null; // initiate a inputStream for user file usable by method

        while (true) {
            File tmpFile = new File(fileName + ".txt"); // new file variable with file name and txt extension
            // used to for checking if the file already exists
            if (tmpFile.exists() && tmpFile.isFile()) { // if it exists and is a file we can't use it
                System.out.println("Found file named: " + fileName + ".txt");
                fileName += 1;
            } else {
                try{
                    tmpOutputStream = new PrintWriter(new FileOutputStream(fileName + ".txt"));
                    System.out.println("Created temporary file output stream: " + fileName + ".txt");
                } catch (FileNotFoundException e){
                    System.out.println("Error creating temporary file output stream.");
                }
                break;
            }
        }


        // Read in the name of the user file to be edited and create user file input stream
        while(true){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What is the name of the file that you would like to edit (include file type extension): ");
            String userFileName = keyboard.next();
            File userFile = new File(userFileName); // new file variable to check if the file exists
            if (userFile.exists() && userFile.isFile()){
                try{
                    userInputStream = new Scanner(new FileInputStream(userFileName));
                    System.out.println("Created user file inputStream named: " + userFileName);
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println("Error creating user file inputSteam.");
                }
            } else {
                System.out.println("The file name given does not exist.");
            }
        }


        //TODO Copy contents of user file into temporary file w/o spaces but with new line
        // Copy Despaced contents into new user file
        while (userInputStream.hasNextLine()){
            String newLine = userInputStream.nextLine();
            System.out.println(newLine);
        }
        //TODO Copy back the content of the file into the original file
        //TODO Remove the temporary file

    }
}
