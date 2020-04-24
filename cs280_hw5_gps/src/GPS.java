import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.*;

public class GPS {
    /*
    The GPS class uses the Waypoint and Journey subclases to measure the distance and speed of an object
    traveling on an x,y coordinate plane. It does this by prompting the user for waypoints, adding them to the waypoints
    list, the calculating the total distance between waypoints in the list, and dividing it by the dividing the total
    distance by the final time value entered. The waypoints do not need to be in order of time. I have used a simple
    counting sort algorithm to sort by time.
     */
    public static void main(String[] args) {
        // Initialize GPS
        ArrayList<Waypoint> waypointList = new ArrayList<>();
        Waypoint w0 = new Waypoint();
        waypointList.add(w0);
        System.out.println("GPS initialized, this location is point 0,0. Time is 0.");

        // Prompt and Add Waypoints
        waypointList = promptAndAddWaypoints(waypointList);

        // Sort Waypoints by time
        waypointList = waypointSort(waypointList);

        // Output Data
        System.out.println("Waypoints have been entered, calculating distance and speed.");
        Journey currentJourney = calculateDistanceAndSpeed(waypointList);
        System.out.printf("Total Distance Traveled: %.2f mile(s)", + currentJourney.distance);
        System.out.printf("\nTotal Time Elapsed: %.2f hour(s)", currentJourney.time);
        System.out.printf("\nAverage Speed: %.2f mph", currentJourney.speed);
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
                System.out.println("Enter the next waypoint's x value in 10ths of a mile. " +
                        "\nEnter -1 to stop entering waypoints.");
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
        double totalTime = (lst.get(lst.size()-1).time)/3600; // The total time is the time value for the last waypoint.
        double averageSpeed;

        // Get total distance traveled and total time traveled
        for (int i = 1; i < lst.size(); i++){
            Waypoint currentWaypoint = lst.get(i);
            Waypoint previousWaypoint = lst.get(i-1);
            totalDistance = totalDistance + currentWaypoint.distanceFrom(previousWaypoint)/10.0;
        }

        // Calculate the average speed can't divide by zero
        if (totalTime != 0){
            averageSpeed = totalDistance / totalTime;
        } else {
            averageSpeed = 0;
        }

        return new Journey(totalDistance,averageSpeed, totalTime);
    }

    public static ArrayList<Waypoint> waypointSort(ArrayList<Waypoint> lst) {
        Waypoint maxWaypoint = new Waypoint(0,0,-1);
        ArrayList<Waypoint> newWaypointList = new ArrayList<>();
        // Find max
        while (lst.size() > 0) {
            int index = 0;
            int removeIndex = 0;
            maxWaypoint = new Waypoint(0,0,-1);
            for (Waypoint w: lst) {
                if (w.time > maxWaypoint.time){
                    maxWaypoint = w;
                    removeIndex = index;
                }
                index += 1;
            }
            lst.remove(removeIndex);
            newWaypointList.add(0,maxWaypoint);
        }
        return newWaypointList;
    }

    public static class Waypoint {

        // Instance Variables
        double x_coordinate;
        double y_coordinate;
        int time;

        // Constructors

        // No argument constructor
        public Waypoint(){
            x_coordinate = 0;
            y_coordinate = 0;
            time = 0;
        }

        // Full argument constructor
        public Waypoint(double x,double y, int t){
            boolean valid = false;
            x_coordinate = x;
            y_coordinate = y;
            if (t > 0){
                time = t;
                valid = true;
            }
        }

        // Get and Set Methods
        public double getX_coordinate() {
            return x_coordinate;
        }

        public double getY_coordinate() {
            return y_coordinate;
        }

        public int getTime() {
            return time;
        }

        public boolean setX_coordinate(double x) {
            x_coordinate = x;
            return true;
        }

        public boolean setY_coordinate(double y) {
            y_coordinate = y;
            return true;
        }

        public boolean setTime(int t) {
            time = t;
            return true;
        }

        // Find the distance from another waypoint.
        public double distanceFrom(Waypoint w){
            double distance = 0;

            // Get differences of y and x
            double y_difference = abs(this.y_coordinate - w.y_coordinate);
            double x_difference = abs(this.x_coordinate - w.x_coordinate);

            // Check to see if vertical or horizontal location change
            if (y_difference == 0 && x_difference == 0){
                distance = 0;
            } else if (y_difference == 0){
                distance = x_difference;
            } else if (x_difference == 0){
                distance = y_difference;
            } else {
                distance = sqrt(pow(y_difference,2) + pow(x_difference,2));
            }

            return distance;
        }

        public int timeDifference(Waypoint w) {
            return this.time - w.time;
        }
    }

    public static class Journey {
    /*  The journey class is used by the GPS class in order to return distance and speed
        from a single method */

        // Instance variables
        double distance;
        double speed;
        double time;

        // Constructor
        public Journey(double d, double s, double t){
            distance = d;
            speed = s;
            time = t;
        }

        //Get and Set Methods
        public double getDistance() {
            return distance;
        }

        public double getSpeed() {
            return speed;
        }

        public double getTime() {
            return time;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public void setTime(double time) {
            this.time = time;
        }
    }
}
