import static java.lang.Math.abs;

public class Waypoint {

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
    public boolean Waypoint(double x,double y, int t){
        boolean valid = false;
        x_coordinate = x;
        y_coordinate = y;
        if (t > 0){
            time = t;
            valid = true;
        }
        return valid;
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
        double y_difference = abs(this.y_coordinate - w.y_coordinate);
        double x_difference = abs(this.x_coordinate - w.x_coordinate);

    }
}
