import java.util.ArrayList;
import java.util.Scanner;

//TODO Finish the prompting system
//TODO Create the calculate distance and speed method

public class GPS {
    public static void main(String[] args) {
        // Initialize GPS
        ArrayList<Waypoint> waypointList = new ArrayList<>();
        Waypoint w0 = new Waypoint();
        waypointList.add(w0);
        System.out.println("System initialized, this location is point 0,0. Time is 0.");

        // GPS waypoint add loop
        while (true) {
            // Waypoint variables
            double x;
            double y;
            int t;

            // Prompt for waypoints
            Scanner keyboard = new Scanner(System.in);

            // GPS prompt for x value loop
            while (true) {
                System.out.println("Enter the next waypoint's x value.");
                try {
                    x = keyboard.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid x value.");
                }
            }

            // If the x value entered is less than 0 the systems quits prompting
            if (x < 0) {
                break;
            }

            // GPS prompt for y value loop
            while (true) {
                System.out.println("Enter the next waypoint's y value.");
                try {
                    y = keyboard.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid y value.");
                }
            }

            // GPS prompt for t value loop
            while (true) {
                System.out.println("Enter the next waypoint's time value.");
                try {
                    t = keyboard.nextInt();
                    if (t < 0){
                        System.out.println("Invalid time value, must be greater than 0.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid time value.");
                }
            }

            // Add the new waypoint to the waypoint list.
            waypointList.add(new Waypoint(x,y,t));
        }
    }

    public Journey calculateDistanceAndSpeed(ArrayList<Waypoint> lst) {
        double totalDistance;
        int totalTime;
    }
}
