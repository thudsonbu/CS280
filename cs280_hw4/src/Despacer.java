import java.io.*;
import java.util.Scanner;

public class Despacer {
    public static void main(String[] args){

        // Generate a unique temporary file name and create temporary file output stream
        String tmpFileName = "temporaryfile";
        PrintWriter tmpOutputStream = null; // initiate a outputStream for temporary file usable by method
        Scanner userInputStream = null; // initiate a inputStream for user file usable by method


        // Read in the name of the user file to be edited and create user file input stream
        String userFileName = null;
        Scanner keyboard = new Scanner(System.in);
        while(true){
            System.out.println("What is the name of the file that you would like to edit (include file type extension): ");
            userFileName = keyboard.next();
            File userFile = new File(userFileName); // new file variable to check if the file exists
            if (userFile.exists() && userFile.isFile()){
                try{
                    userInputStream = new Scanner(new FileInputStream(userFileName));
                    System.out.println("Created user file inputStream named: " + userFileName);
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println("Error creating user file inputSteam.");
                    System.exit(-1);
                }
            } else {
                System.out.println("The file name given does not exist.");
            }
        }
        keyboard.close();

        while (true) {
            File tmpFile = new File(tmpFileName + ".txt"); // new file variable with file name and txt extension
            // used to for checking if the file already exists
            if (tmpFile.exists() && tmpFile.isFile()) { // if it exists and is a file we can't use it
                System.out.println("Found file named: " + tmpFileName + ".txt");
                tmpFileName += 1;
            } else {
                try{
                    tmpOutputStream = new PrintWriter(new FileOutputStream(tmpFileName + ".txt",true));
                    System.out.println("Created temporary file output stream: " + tmpFileName + ".txt");
                } catch (FileNotFoundException e){
                    System.out.println("Error creating temporary file output stream.");
                    System.exit(-1);
                }
                break;
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
        tmpOutputStream.close(); // Closing this stream flushes the buffer into the tmp file
        System.out.println("Edited contents have been copied to temporary file.");

        // Create new streams for copying from tmp file to user file
        PrintWriter userOutputStream = null;
        Scanner tmpInputStream = null;
        try{
            tmpInputStream = new Scanner(new FileInputStream(tmpFileName + ".txt"));
            System.out.println("Input stream from temporary file created.");
        } catch (FileNotFoundException e){
            System.out.println("Error creating temporary file input stream.");
            System.exit(-1);
        }
        try{
            userOutputStream = new PrintWriter(new FileOutputStream(userFileName));
            System.out.println("Output stream to user file created.");
        } catch (FileNotFoundException e){
            System.out.println("Error creating user file output stream.");
            System.exit(-1);
        }


        // Copy from tmp file to user file
        while (tmpInputStream.hasNextLine()){
            String newLine = tmpInputStream.nextLine();
            userOutputStream.println(newLine);
        }
        userOutputStream.close(); // closing the user output stream flushes text to the file
        tmpInputStream.close();
        System.out.println("Temporary file has been copied to user file.");


        //Remove the temporary file
        File tmpFile = new File(tmpFileName + ".txt");
        tmpFile.delete();
        System.out.println("Temporary file has been deleted.");
    }
}
