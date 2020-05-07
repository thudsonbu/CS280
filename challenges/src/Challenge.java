import java.util.*;

public class Challenge {
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

    public static void main(String[] args) {
        System.out.println(getXO("XxoO"));
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
