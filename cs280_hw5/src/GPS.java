import java.util.ArrayList;
import java.util.Scanner;

//TODO Output Formatting
//TODO Journey and Waypoint as Subclasses

public class GPS {
    public static void main(String[] args) {
        // Initialize GPS
        ArrayList<Waypoint> waypointList = new ArrayList<>();
        Waypoint w0 = new Waypoint();
        waypointList.add(w0);
        System.out.println("GPS initialized, this location is point 0,0. Time is 0.");

        // Prompt and Add Waypoints
        waypointList = promptAndAddWaypoints(waypointList);

        calculateDistanceAndSpeed(waypointList);

        System.out.println("Waypoints have been entered, calculating distance and speed.");
        Journey currentJourney = calculateDistanceAndSpeed(waypointList);
        System.out.println("Total Distance Traveled: " + currentJourney.distance);
        System.out.println("Total Time Elapsed: " + currentJourney.time);
        System.out.println("Average Speed: " + currentJourney.speed);

    }

    public static ArrayList<Waypoint> promptAndAddWaypoints(ArrayList<Waypoint> waypointList){
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
                System.out.println("Enter the next waypoint's x value in 10ths of a mile.");
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
                System.out.println("Enter the next waypoint's y value in 10ths of a mile.");
                try {
                    y = keyboard.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid y value.");
                }
            }

            // GPS prompt for t value loop
            while (true) {
                System.out.println("Enter the next waypoint's time value in seconds.");
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

        return waypointList;
    }

    public static Journey calculateDistanceAndSpeed(ArrayList<Waypoint> lst) {
        // Variables to use for calculations
        double totalDistance = 0;
        double totalTime = 0;
        double averageSpeed;

        // Get total distance traveled and total time traveled
        for (int i = 1; i < lst.size(); i++){
            Waypoint currentWaypoint = lst.get(i);
            Waypoint previousWaypoint = lst.get(i-1);
            totalDistance = totalDistance + currentWaypoint.distanceFrom(previousWaypoint)/10.0;
            totalTime = totalTime + (double)currentWaypoint.timeDifference(previousWaypoint)/3600.0;
        }

        // Calculate the average speed can't divide by zero
        if (totalTime != 0){
            averageSpeed = totalDistance / totalTime;
        } else {
            averageSpeed = 0;
        }

        return new Journey(totalDistance,averageSpeed, totalTime);
    }
}
