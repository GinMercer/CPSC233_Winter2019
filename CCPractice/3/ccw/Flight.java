public class Flight extends TripComponent{
	private String departureAirport;
	private String arrivalAirport;
	
	public Flight(Date start, Date end, String departureAirport, String arrivalAirport){
		
	}
	public Flight(Flight f){
		this.(f.getStart(), f.getEnd(), f.getDepartureAirport(), f.getArrivalAirport());
	}
	
	public String getDepartureAirport(){
		
	}
	public void setDepartureAirport(String airport){
		
	}
	
	public String getArrivalAirport(){
		
	}
	public void setArrivalAirport(String airport){
		
	}
	
	public String getStart(){
		
	}
	
	public String getEnd(){
		
	}
	
	public String getDuration(){
		
	}	
}