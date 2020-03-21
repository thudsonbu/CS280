import java.util.ArrayList;

public class Challenge {
    /*
     Create a function that tests whether or not an integer is a perfect number. A perfect number is a number that can
     be written as the sum of its factors, excluding the number itself.
     */
    public static boolean checkPerfect(int num) {
        ArrayList<Integer> factors = new ArrayList<Integer>(0);
        int i = 1;
        while (i < num) {
            if (num % i == 0) {
                factors.add(i);
            }
            i++;
        }
        int sum = 0;
        for (Integer factor : factors) {
            sum += factor;
        }
        return sum == num;
    }

    /*
     Create a function that takes two strings and returns true if the first string ends with the second string;
     otherwise return false.
     */

    public static boolean checkEnding(String str1, String str2) {
        return str1.substring(str1.length()-str2.length()).equals(str2);
    }

    /*
     Create a function that reverses the order of a string.
     */

    public static String reverse(final String str) {
        String reversed = "";
        for (int i = str.length()-1; i >= 0; i-=1){
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }

    /*
     Write a function that takes a string name and a number num (either 0 or 1) and return "Hello" + name if num is 1,
     otherwise return "Bye" + name.
     */

    public static String sayHelloBye(String name, int num) {
        String greeting = "";
        if (num == 1){
            greeting = "Hello ";
        } else {
            greeting = "Bye ";
        }
        return greeting + name;
    }

    public static void main(String[] args){
        System.out.println(sayHelloBye("Tom", 1));
    }


    /*
    Create a function that takes a single word string and does the following:
    1. Concatenates inator to the end if the word ends with a consonant otherwise, concatenate -inator instead.
    2. Adds the word length of the original word to the end, supplied with '000'.
    */

    public static String inatorInator(String inv) {
        // Get length
        int length = inv.length();
        String add = "inator ";
        // Determine if consonant
        String[] consonants = {"a","e","i","o","u"};
        for (int i = 0; i < 5; i++){
            if (consonants[i].equals(inv.substring(length - 1))){
                add = "-inator ";
            }
        }
        return inv + add + length + "000";
    }
}
