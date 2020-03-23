public class Journey {
    /*  The journey class is used by the GPS class in order to return distance and speed
        from a single method */

    // Instance variables
    double distance;
    double speed;

    // Consturctor
    public Journey(double d, double s){
        distance = d;
        speed = s;
    }

    //Get and Set Methods
    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
