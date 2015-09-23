package homeworkFall2015;

abstract public class Taxi {

	int speed;
	
	int cost;
	
	void drive() {};
	
}

abstract class TaxiLux extends Taxi {
	
	int speed;
	
	int cost;
	
	@Override
	void drive() {};
	
	String wiFi = "Fast";
	
	boolean seatIsSoft = true;
	
}

abstract class TaxiEconom extends Taxi {
	
	int speed;
	
	int cost;
	
	@Override
	void drive() {};
	
	String wiFi = "Slow";
	
	boolean seatIsSoft = false;
}

class RollsRoyce extends TaxiLux {
	
	int speed = 110;
	
	int cost = 250;
	
	@Override
	void drive() {
		
		System.out.println( "RollsRoyce goes fast and smooth and looks great" );
	};
	
	String wiFi = "Fast";
	
	boolean seatIsSoft = true;
}

class Hummer extends TaxiLux {
	
	int speed = 70;
	
	int cost = 230;
	
	@Override
	void drive() {
		
		System.out.println( "Hummer goes slow but smooth and looks great" );
	};
	
	String wiFi = "slow";
	
	boolean seatIsSoft = true;
}

class Priora extends TaxiEconom {
	
	int speed = 60;
	
	int cost = 140;
	
	@Override
	void drive() {
		
		System.out.println( "Priora goes slow but smooth" );
	};
	
	boolean seatIsSoft = false;
}

class Zaporozhets extends TaxiEconom {
	
	int speed = 50;
	
	int cost = 50;
	
	@Override
	void drive() {
		
		System.out.println( "Zaporozhets goes slow and bumpy and looks terrible" );
	};
	
	boolean seatIsSoft = false;
}