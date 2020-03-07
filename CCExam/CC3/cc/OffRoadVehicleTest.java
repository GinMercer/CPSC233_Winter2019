import static org.junit.Assert.*;

import org.junit.Test;

public class OffRoadVehicleTest extends FormatTester{

	public static final String CLASSNAME = "OffRoadVehicle";

	public OffRoadVehicleTest() {
		super(CLASSNAME, false);
	}

	private void testClassDefinition(){
		String[] instanceVars = {"String classification"};
		assertTrue("Instance variables should be private with correct name and type.", instanceVariablesArePrivate(instanceVars));

		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
		assertFalse("Should not override getMileage.", hasMethod("int getMileage"));
		assertFalse("Should not override toString.", hasMethod("String toString"));
	}

	// Testing constructors

	@Test
	public void test_Constructor_Truck() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "Truck");
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing make", "honda", v.getMake());
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing model", "CIVIC", v.getModel());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing mileage", 10, v.getMileage());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing classification", "Truck", v.getClassification());
	}

	@Test
	public void test_Constructor_ATV() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "ATV");
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing make", "honda", v.getMake());
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing model", "CIVIC", v.getModel());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing mileage", 10, v.getMileage());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing classification", "ATV", v.getClassification());
	}

	@Test
	public void test_Constructor_Motorcycle() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "Motorcycle");
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing make", "honda", v.getMake());
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing model", "CIVIC", v.getModel());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing mileage", 10, v.getMileage());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing classification", "Motorcycle", v.getClassification());
	}

	@Test
	public void test_Constructor_InvalidClassification() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "Other");
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing make", "honda", v.getMake());
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing model", "CIVIC", v.getModel());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing mileage", 10, v.getMileage());
		assertNull("Created OffRoadVehicle with invalid classification, expecting classification to be null", v.getClassification());
	}


	@Test
	public void test_Constructor_nullClassification() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, null);
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing make", "honda", v.getMake());
		assertEquals("Created OffRoadVehicle with 'honda' make 'civic' model and mileage 10 - testing model", "CIVIC", v.getModel());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing mileage", 10, v.getMileage());
		assertNull("Created OffRoadVehicle with null classification, expecting classification to be null", v.getClassification());
	}

	@Test 
	public void test_CopyConstructor_Truck() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("make1", "TEST1", 10, "Truck");
		OffRoadVehicle v2 = new OffRoadVehicle(v);
		assertEquals("Testing Copy Constructor, copying 'make1' make, 'TEST1' model and mileage 10 - testing make", "make1", v2.getMake());
		assertEquals("Testing Copy Constructor, copying 'make1' make, 'TEST1' model and mileage 10 - testing model", "TEST1", v2.getModel());
		assertEquals("Testing Copy Constructor, copying 'make1' make, 'TEST2' Copy Constructor' model and mileage 10 - testing mileage", 10, v2.getMileage());
		assertEquals("Created OffRoadVehicle with 'honda' make, 'civic' model and mileage 10 - testing classification", "Truck", v2.getClassification());
	}

	@Test 
	public void test_CopyConstructor_null() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("MAKE2", "Test2", 20, null);
		OffRoadVehicle v2 = new OffRoadVehicle(v);
		assertEquals("Testing Copy Constructor, copying 'MAKE2' make 'Test2' model and mileage 20 - testing make", "make2", v2.getMake());
		assertEquals("Testing Copy Constructor, copying 'MAKE2' make 'Test2' model and mileage 20 - testing model", "TEST2", v2.getModel());
		assertEquals("Testing Copy Constructor, copying 'MAKE2' make, 'Test2' model and mileage 20 - testing mileage", 20, v2.getMileage());
		assertNull("Testing Copy Constructor with null classification, expecting copy classification to be null", v2.getClassification());
	}


	// Testing setter and getters

	@Test
	public void test_setter_and_getter_classification_Truck(){
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, null);
		v.setClassification("Truck");
		assertEquals("Changed classification from null to Truck", "Truck", v.getClassification());
	}
	
	@Test
	public void test_setter_and_getter_classification_ATV(){
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "Truck");
		v.setClassification("ATV");
		assertEquals("Changed classification from Truck to ATV", "ATV", v.getClassification());
	}
	
	@Test
	public void test_setter_and_getter_classification_Motorcycle(){
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "Truck");
		v.setClassification("Motorcycle");
		assertEquals("Changed classification from Truck", "Motorcycle", v.getClassification());
	}
	
	@Test
	public void test_setter_and_getter_classification_Invalid(){
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "Motorcycle");
		v.setClassification("Something");
		assertNull("Changed classification from Motorcycle to some invalid classification", v.getClassification());
	}
	
	@Test
	public void test_setter_and_getter_classification_null(){
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "ATV");
		v.setClassification(null);
		assertNull("Changed classification to null", v.getClassification());
	}
	
	@Test
	public void test_getFuelEfficiency_Truck() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("Fiat", "City", 0, "Truck");
		v.setMileage(6);
		assertEquals("Efficiency for worst vehicle fueld efficiency is average for OffRoad Truck", "average", v.getFuelEfficiencyCategory());
		v.setMileage(13);
		assertEquals("Efficiency for average vehicle fueld efficiency is good for OffRoad Truck", "good", v.getFuelEfficiencyCategory());
		v.setMileage(23);
		assertEquals("Efficiency for best vehicle fueld efficiency is amazing for OffRoad Truck", "amazing", v.getFuelEfficiencyCategory());
	}
	
	@Test
	public void test_getFuelEfficiency_ATV() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("Fiat", "City", 0, "ATV");
		v.setMileage(6);
		assertEquals("Efficiency for worst vehicle fueld efficiency is average for OffRoad ATV", "poor", v.getFuelEfficiencyCategory());
		v.setMileage(13);
		assertEquals("Efficiency for average vehicle fueld efficiency is good for OffRoad ATV", "average", v.getFuelEfficiencyCategory());
		v.setMileage(23);
		assertEquals("Efficiency for best vehicle fueld efficiency is amazing for OffRoad ATV", "good", v.getFuelEfficiencyCategory());
	}
	@Test
	public void test_getFuelEfficiency_Motorcycle() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("Fiat", "City", 0, "Motorcycle");
		v.setMileage(6);
		assertEquals("Efficiency for worst vehicle fueld efficiency is average for OffRoad Motorcycle", "dismal", v.getFuelEfficiencyCategory());
		v.setMileage(13);
		assertEquals("Efficiency for average vehicle fueld efficiency is good for OffRoad Motorcycle", "poor", v.getFuelEfficiencyCategory());
		v.setMileage(23);
		assertEquals("Efficiency for best vehicle fueld efficiency is amazing for OffRoad Motorcycle", "average", v.getFuelEfficiencyCategory());
	}
	
	@Test
	public void test_getFuelEfficiency_nullClassification() {
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("Fiat", "City", 0, null);
		v.setMileage(6);
		assertEquals("Efficiency for worst vehicle fueld efficiency remains worst without classification", "worst", v.getFuelEfficiencyCategory());
		v.setMileage(13);
		assertEquals("Efficiency for average vehicle fueld efficiency remains average without classification", "average", v.getFuelEfficiencyCategory());
		v.setMileage(23);
		assertEquals("Efficiency for best vehicle fueld efficiency remains best without classification", "best", v.getFuelEfficiencyCategory());
	}

	// checking that toString uses overridden method (it is not overridden).
	@Test
	public void test_toString(){
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("honda", "civic", 10, "Truck");
		assertEquals("Testing toString for vehicle with honda make, civic model and 10 mileage and Truck classification",
				"honda-CIVIC-good fuel efficiency", v.toString());
	}

	@Test
	public void test_toString2(){
		testClassDefinition();
		OffRoadVehicle v = new OffRoadVehicle("Fiat", "City", 22, "Motorcycle");
		assertEquals("Testing toString for vehicle with fiat make, city model and 22 mileage and motorcycle classification",
				"fiat-CITY-average fuel efficiency", v.toString());
	}
	
}
