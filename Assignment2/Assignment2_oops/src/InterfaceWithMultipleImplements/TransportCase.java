package InterfaceWithMultipleImplements;
/*Create an interface Transport with method booking().
Implement it in Bus and Flight classes.
Call using interface reference.*/

interface Transport {
	void booking(int fare, String partner, String time);
}

class Bus implements Transport{
	public void booking(int busFare, String busPartner, String bus_time) {
		System.out.println("Your "+ busPartner + " will arrive at " + bus_time + " and the bus fare is " + busFare);
	}
	
}

class Flight implements Transport{
	public void booking(int flightFare, String FlightPartner, String flight_time) {
		System.out.println("Your "+ FlightPartner + " will arrive at " + flight_time + " and the flight fare is " + flightFare);

	}
}
public class TransportCase {

	public static void main(String[] args) {
		Transport ref = new Bus();
		ref.booking(2300, "Flix", "10.30 AM");
		
		Transport ref1 = new Flight();
		ref1.booking(8765, "Indigo", "4.20PM");
		

	}

}
