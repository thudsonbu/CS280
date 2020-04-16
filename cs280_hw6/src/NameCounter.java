/* NameCounter reads two lists of the most popular boy and girl names from a text files with their respective
* counts and sums the counts. A the total count of names that both lists have in common is also returned. */

import java.io.*;
import java.util.Scanner;
import java.util.HashSet;

public class NameCounter {
    public static void main(String[] args) {

        // Get stuff setup
        File boyNames = new File("boynames.txt");
        File girlNames = new File("girlnames.txt");
        Scanner girlNamesInput = null;
        Scanner boyNamesInput = null;

        // Establish connection with girl names file.
        if (girlNames.exists() && girlNames.isFile()) {
            try {
                girlNamesInput = new Scanner(new FileInputStream("girlnames.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("The girlnames.txt file was not found.");
            }
        }

        //Establish connection with boy names file.
        if (boyNames.exists() && boyNames.isFile()) {
            try {
                boyNamesInput = new Scanner(new FileInputStream("boynames.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("The boynames.txt file was not found.");
            }
        }

        // Add girl names to hashset and sum girl name counts
        int girlSum = 0;
        HashSet<String> girls = new HashSet<String>();
        for (int i = 0; i < 1000; i++){
            String girlName = girlNamesInput.next(); // get girl name
            int nameCount = girlNamesInput.nextInt(); // get girl name count
            girlSum += nameCount; // add count to girlSum
            girls.add(girlName); // add girl name to set
        }

        // Add boy names to hashset and sum boy name counts
        int boySum = 0;
        HashSet<String> boys = new HashSet<String>();
        for (int i = 0; i < 1000; i++) {
            String boyName = boyNamesInput.next();
            int nameCount = boyNamesInput.nextInt();
            boySum += nameCount;
            boys.add(boyName);
        }

        // Print sums
        System.out.println("The girl name count is " + girlSum);
        System.out.println("The boy name count is " + boySum);

        // Merge Hashsets of boys and girls names returning only those in common
        girls.retainAll(boys);
        int commonSum = 0;
        for (String name : girls) {
            commonSum += 1;
        }

        // Print how many names are in common between hashsets
        System.out.println("There are " + commonSum + " names in common.");
    }
}
