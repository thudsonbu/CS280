public class Journey {
    /*  The journey class is used by the GPS class in order to return distance and speed
        from a single method */

    // Instance variables
    double distance;
    double speed;
    int time;

    // Consturctor
    public Journey(double d, double s, int t){
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

    public int getTime() {
        return time;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
