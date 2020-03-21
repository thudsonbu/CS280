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

    public static void main(String[] args){
        System.out.println(checkPerfect(6));
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
