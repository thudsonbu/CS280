import java.lang.reflect.Array;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Challenge {
    //Create a method that takes an array of 10 integers (between 0 and 9) and returns a string of those numbers
    // formatted as a phone number (e.g. (555) 555-5555).
    public static String formatPhoneNumber(int[] nums) {
        // Return string
        String out = "(";
        // Add each number to string
        for (int i = 0; i < 13; i++) {
            // Insert first three digits
            if (i < 3){
                out += nums[i];
            }
            // Insert )
            else if (i == 3) {
                out += ")";
            }
            // Insert _
            else if (i == 4) {
                out += " ";
            }
            // Insert second three digits
            else if (i < 8){
                out += nums[i-2];
            }
            // Insert -
            else if (i == 8) {
                out += "-";
            }
            // Insert last four digits
            else {
                out += nums[i-3];
            }
        }
        return out;
    }

    //Given two strings, s1 and s2, select only the characters in each string where the character in the same position
    // in the other string is in uppercase. Return these as a single string.
    public static String selectLetters(String s1, String s2) {
        // Return string
        String out = "";
        // Find max length
        int length = (s1.length() > s2.length()) ? s2.length() : s1.length();
        // Split strings
        String[] string1 = s1.split("");
        String[] string2 = s2.split("");
        // Iterate through s2 checking for case and appending to out string from s1
        for (int i = 0; i < length; i++) {
            if (!string2[i].equals(string2[i].toLowerCase())){
                out = out + string1[i];
            }
        }
        // Iterate through s1 checking for case and appending to out string from s2 if upper case
        for (int i = 0; i < length; i++) {
            if (!string1[i].equals(string1[i].toLowerCase())){
                out = out + string2[i];
            }
        }
        return out;
    }

    public static void main(String[] args){
        int[] phoneNumber = {7,2,0,6,2,6,7,6,4,6};
        System.out.println(formatPhoneNumber(phoneNumber));
    }


    // If you take an integer and form the product of it's individual digits, you get a smaller number. Keep doing this
    // and eventually you end up with a single digit.
    public static int persistence(long num) {
        int out = 0;
        while (true) {
            // Convert to String
            String number = Long.toString(num);
            // Check length
            if (number.length() == 1){
                break;
            }
            // Break up string
            String[] potato = number.split("");
            // Multiply together
            long multiplied = 1;
            for (String a : potato) {
                multiplied = multiplied * Long.parseLong(a);
            }
            num = multiplied;
            out++;
        }
        return out;
    }


    // Create a function that determines whether elements in an array can be re-arranged to form a consecutive list of
    // numbers where each number appears exactly once.
    public static boolean cons(int[] arr) {
        boolean consecutive = true;
        // Sort Array
        Arrays.sort(arr);
        // Iterate through each item
        for (int i = 1; i < arr.length; i++){
            if (arr[i] - 1 == arr[i-1]) continue; // check if next item is consecutive
            else {
                consecutive = false;
            }
        }
        return  consecutive;
    }


    // Create a function that takes an array of numbers and return "Boom!" if the number 7 appears in the array. Otherwise,
    // return "there is no 7 in the array".
    public static String sevenBoom(int[] arr) {
        String out = "there is no 7 in the array";
        // Iterate through each array element
        for (int i : arr) {
            // Cast the array to a String
            String number = Integer.toString(i);
            // Go through each character to check if 7
            for (int a = 1; a <= number.length(); a++){
                // Grab character
                String character = number.substring(a-1,a);
                // Check if 7
                if (character.equals("7")){
                    out = "Boom!";
                }
            }
        }
        return out;
    }
    // Better Solution
    public static String sevenBoom2(int[] arr) {
        return Arrays.toString(arr).contains("7") ? "Boom!"
                : "there is no 7 in the array";
    }


    // Create a function that takes a string, checks if it has the same number of x's and o's and returns either true or false.
    public static boolean getXO (String str) {
        int xTotal = 0;
        int oTotal = 0;
        for (int i = 1; i <= str.length(); i++){
            String character = str.substring(i-1,i);
            if (character.equalsIgnoreCase("x")) xTotal +=1;
            else  if (character.equalsIgnoreCase("o")) oTotal +=1;
        }
        return xTotal == oTotal;
    }


    /* Create a function that tests whether or not an integer is a perfect number. A perfect number is a number that can
     be written as the sum of its factors, excluding the number itself. */
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


    /* Given an unsorted array, create a function that returns the nth smallest element (the smallest element is the
    first smallest, the second smallest element is the second smallest, etc).*/
    public static int nthSmallest(int[] arr, int n) {
        int out = 0;
        // Check if just smallest
        if (n == 1) {
            // Just get the smallest
            int smallest = arr[0];
            for (int i : arr){
                if (i < smallest){
                    smallest = i;
                }
            }
            out = smallest;
        // Check if array long enough
        } else if (n <= arr.length) {
            // Find the smallest number
            int currentMin = arr[0];
            for (int i : arr) {
                if (i < currentMin) {
                    currentMin = i;
                }
            }
            // Iterate through searching for smallest, then 2nd smallest ...
            int place = 2;
            int newMin = 5; // Five is arbitrary
            for (int i = 0; i < n-1; i++) {
                // Find a new number that greater then previous iteration smallest to start with
                for (int a : arr) {
                    if (a > currentMin) {
                        newMin = a;
                    }
                }
                // Find _ smallest
                for (int b : arr) {
                    if (b > currentMin && b < newMin) {
                        newMin = b;
                    }
                }
                System.out.println("The " + place + " smallest is " + newMin);
                place += 1;
                currentMin = newMin;
            }
            out = newMin;
        } else {
            out = -1;
        }
        return out;
    }


    // Given an array of integers, write a method that returns an array that has all duplicate elements removed, and is
    // stored from the least value to the greatest value.
    public static int[] uniqueSort(int[] nums) {
        HashSet<Integer> potato = new HashSet<>();
        for (int i : nums) {
            potato.add(i);
        }
        int[] out = new int[potato.size()];
        int position = 0;
        for (int a : potato){
            out[position] = a;
            position++;
        }
        Arrays.sort(out);
        return out;
    }
    // Better solution
    public static int[] uniqueSort2(int[] nums) {
        return java.util.Arrays.stream(nums).distinct().sorted().toArray();
    }


    // Create a function that takes two numbers as arguments (num,length) and returns an array of multiples up to length.
    public static int[] arrayOfMultiples(int num, int length) {
        int[] multiples = new int[length];
        int multiple = 0;
        for (int i = 0; i < length;i++) {
            multiple += num;
            multiples[i] = multiple;
        }
        return multiples;
    }


    /* Create a function that takes two strings and returns true if the first string ends with the second string;
     otherwise return false.*/
    public static boolean checkEnding(String str1, String str2) {
        return str1.substring(str1.length()-str2.length()).equals(str2);
    }


    // Create a function that reverses the order of a string.
    public static String reverse(final String str) {
        String reversed = "";
        for (int i = str.length()-1; i >= 0; i-=1){
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }


    // Create a method that takes a string and returns the word count. The string will be a sentence.
    public static int countWords(String s) {
        String[] words = s.split(" ");
        return words.length;
    }


    /*Write a function that takes a string name and a number num (either 0 or 1) and return "Hello" + name if num is 1,
     otherwise return "Bye" + name.*/
    public static String sayHelloBye(String name, int num) {
        String greeting = "";
        if (num == 1){
            greeting = "Hello ";
        } else {
            greeting = "Bye ";
        }
        return greeting + name;
    }


    /* Create a function that takes a single word string and does the following:
    1. Concatenates inator to the end if the word ends with a consonant otherwise, concatenate -inator instead.
    2. Adds the word length of the original word to the end, supplied with '000'.*/
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
