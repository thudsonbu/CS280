import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class PlatformDiving {
    public static void main(String[] args) {
        // 1. Read in the judges scores
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            System.out.println("Enter a score as a floating point.");
            double score = keyboard.nextDouble();
            scores.add(0,score);
        }

        // 2. Sum up scores after removing highest and lowest
        Collections.sort(scores);
        scores.remove(scores.size()-1);
        scores.remove(0);
        double sum = 0;
        for(double value : scores) {
            sum = sum + value;
        }

        // 3. Read in multiplier
        System.out.println("Enter the dive difficulty modifier.");
        Double mult = keyboard.nextDouble();

        // 4. Print final score
        Double finalScore = mult * sum;
        System.out.println("The final score is " + finalScore);
    }
}
