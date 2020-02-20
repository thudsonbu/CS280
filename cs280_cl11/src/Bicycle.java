public class Bicycle {
        
    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;
        
    // the Bicycle class has two constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
    
    public Bicycle() {
    	this(0,0,0);	
    }
        
    //accessors and mutators
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
    
    public void setSpeed(int speed) {
		this.speed = speed;
	}
        
    public int getSpeed() {
		return speed;
	}

	public int getCadence() {
		return cadence;
	}

	public int getGear() {
		return gear;
	}
	
	
	public String toString() {
		return "Bicycle [cadence=" + cadence + ", gear=" + gear + ", speed=" + speed + "]";
	}
	
	
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		else if (obj == null) return false;
		
		else if (this.getClass() != obj.getClass())
			return false;
		else {
		Bicycle other = (Bicycle) obj;
		if (cadence != other.cadence)
			return false;
		if (gear != other.gear)
			return false;
		if (speed != other.speed)
			return false;
		return true;
		}
	}
	

	public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }
        
}
