import java.math.*;

public class test {
    public static int number(boolean thing) {
        return (thing == true) ? 1 : 0; // Cool way for true false testing
    }

    /* Create a function that takes an array as an argument and returns true or false depending on whether
    the average of all elements in the array is a whole number or not.
    */
    public static boolean isAvgWhole(int[] arr) {
        double sum = 0;
        double total = 0;
        for (int i : arr ) {
            sum += i;
            total += 1;
        }
        return (sum/total == Math.floor(sum/total)) ? true : false;
    }

    /*Create a function that takes a whole number as input and returns the shape with that number's amount of sides.
    Here are the expected outputs to get from these inputs.*/

    public static String nSidedShape(int n) {
        String[] shapes = {"circle","semi-circle","triangle","square","pentagon","hexagon","heptagon","octagon",
        "nonagon","decagon"};
        return shapes[n-1];
    }

    /*Create a function that takes an array and returns the difference between the biggest and smallest numbers.
    */
    public static int differenceMaxMin(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr ) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        return max - min;
    }

    public static void main(String[] args) {
        int[] myArray = new int[3];
        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 1;
        boolean a = isAvgWhole(myArray);
        System.out.println(a);
    }
}
