//Please add accessors, mutators, 4 argument constructor calling 3 argument
//constructor of parent class, toString and equals calling those methods of parent class.
public class MountainBike extends Bicycle{
	
	private double seatHeight;

	public MountainBike(int startCadence, int startSpeed, int startGear, double seatHeight) {
		super(startCadence,startSpeed,startGear);
		seatHeight = seatHeight;
	}

	public boolean equals(MountainBike bike){
		return super.equals(bike) && getSeatHeight() == seatHeight;
	}

	public double getSeatHeight() {
		return seatHeight;
	}

	public void setSeatHeight(double seatHeight) {
		this.seatHeight = seatHeight;
	}
}
