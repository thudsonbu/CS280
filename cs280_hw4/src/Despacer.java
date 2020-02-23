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
                    tmpOutputStream = new PrintWriter(new FileOutputStream(fileName + ".txt",true));
                    System.out.println("Created temporary file output stream: " + fileName + ".txt");
                } catch (FileNotFoundException e){
                    System.out.println("Error creating temporary file output stream.");
                }
                break;
            }
        }


        // Read in the name of the user file to be edited and create user file input stream
        while(true){
            /*Scanner keyboard = new Scanner(System.in);
            System.out.println("What is the name of the file that you would like to edit (include file type extension): ");
            String userFileName = keyboard.next();*/
            String userFileName = "potato.txt";
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


        // Copy De-spaced contents into temp file
        while (userInputStream.hasNextLine()){
            String[] wordsInLine; // Create array for words in a line
            String newLine = userInputStream.nextLine(); // Read in a new line
            wordsInLine = newLine.split(" "); // Split the line into words
            for (int i = 0; i < wordsInLine.length; i++){
                wordsInLine[i] = wordsInLine[i].trim(); // Trim each word of leading and trailing spaces.
                tmpOutputStream.print(wordsInLine[i]);
                if (i < wordsInLine.length - 1 && !wordsInLine[i].equals("")){
                    // adds spaces if there is a word there not if it is an empty string this essentially deletes spaces
                    tmpOutputStream.print(" ");
                } else if (i == wordsInLine.length - 1 && !wordsInLine[i].equals("")){
                    tmpOutputStream.print("\n");
                    // adds a new line if it is then of a line and not an empty string
                }
            }
        }

        // Close the streams. We are done with reading user and copying to tmp
        userInputStream.close();
        tmpOutputStream.close();

        //TODO Copy back the content of the file into the original file
        //TODO Remove the temporary file
    }
}
