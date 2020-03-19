public class Challenge {
    /*
    In this challenge, the goal is recomposing scrambled strings made of two or more words.

    Every string has to be reversed not in its totality, but by vowels or consonants clusters in the order they are found;
    after splitting the string in groups, and reversing every group with more than a letter, you'll obtain the correct
    sequence:
     */
    public static String recompose(String str){
        // Identify clusters
        
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

    public static void main(String[] args) {
        System.out.println(inatorInator("potato"));
    }
}
