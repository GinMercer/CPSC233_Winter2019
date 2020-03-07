import static org.junit.Assert.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.Test;

public class TripComponentTest extends FormatTester{
	public static final String CLASSNAME = "TripComponent";

	public TripComponentTest() {
		super(CLASSNAME, false);
	}

	private void testClassDefinition(){
		String[] instanceVars = {"Date start", "Date end"};

		
	}
		
	private Date getDate(int year, int month, int day, int hour, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(year, month, day, hour, minute, 0);
		return cal.getTime();
	}
	
	// Testing constructors

	@Test
	public void testConstructor_startBeforeend(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,10,21));
		Date expectedstart = getDate(2018,11,28,10,20);
		Date expectedend = getDate(2018,11,28,10,21);
		assertEquals("start one minute before end, testing start", expectedstart.toString(), c.getStart());
		assertEquals("start one minute before end, testing end", expectedend.toString(), c.getEnd());
	}

	@Test
	public void testConstructor_startSameAsend(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,27,10,20), getDate(2018,11,27,10,20));
		Date expectedstart = getDate(2018,11,27,10,20);
		Date expectedend = null;
		assertEquals("testing start", expectedstart.toString(), c.getStart());
		assertEquals("testing end (which is null, expecting empty string", "", c.getEnd());
	}

	@Test
	public void testConstructor_startAfterend(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,21), getDate(2018,11,28,10,20));
		Date expectedstart = getDate(2018,11,28,10,21);
		Date expectedend = null;
		assertEquals("start one minute after end, testing start", expectedstart.toString(), c.getStart());
		assertEquals("start one minute after end, testing end", "", c.getEnd());
	}

	@Test
	public void testConstructor_nullstartAndend(){
		testClassDefinition();
		TripComponent c = new TripComponent(null,null);
		Date expectedstart = null;
		Date expectedend = null;
		assertEquals("testing start", "", c.getStart());
		assertEquals("testing end", "", c.getEnd());
	}

	@Test
	public void testConstructor_startEncapsulation(){
		testClassDefinition();
		Date argumentstart = getDate(2019,11,28,10,25);
		TripComponent c = new TripComponent(argumentstart,null);

		// Change argument
		argumentstart.setTime(getDate(2020,10,20,14,0).getTime());

		// Verify that TripComponent start date is unchanged.
		Date expectedstart = getDate(2019,11,28,10,25);

		assertEquals("Changed argument after creation from 2019:11:20:10:25 to 2020:10:20:14:00, expect TripComponent start to remain unchanged.", expectedstart.toString(), c.getStart());
	}

	@Test
	public void testCopyConstructor(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,10,28,10,20), getDate(2018,10,29,1,5));
		TripComponent copy = new TripComponent(c);
		Date expectedstart = getDate(2018,10,28,10,20);
		Date expectedend = getDate(2018,10,29,1,5);
		assertEquals("Testing start", expectedstart.toString(), copy.getStart());
		assertEquals("Testing end", expectedend.toString(), copy.getEnd());
	}

	@Test
	public void testCopyConstructor_nullstartAndend(){
		testClassDefinition();
		TripComponent p = new TripComponent(null,null);
		TripComponent p2 = new TripComponent(p);
		assertEquals("testing start", "", p2.getStart());
		assertEquals("testing end", "", p2.getEnd());
	}

	// Testing setter and getters

	@Test
	public void test_setter_and_getter_start_NewstartBeforeend(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,10,21));
		c.setStart(getDate(2018,11,28,8,0));
		Date expectedstart = getDate(2018,11,28,8,0);
		Date expectedend = getDate(2018,11,28,10,21);
		assertEquals("Changed start to 8am from 10:20am, testing start", expectedstart.toString(), c.getStart());
		assertEquals("Changed start to 8am from 10:20am, testing end", expectedend.toString(), c.getEnd());			
	}

	@Test
	public void test_setter_and_getter_start_fromNullstart(){
		testClassDefinition();
		TripComponent c = new TripComponent(null, getDate(2018,11,28,10,21));
		c.setStart(getDate(2018,11,28,8,0));
		Date expectedstart = getDate(2018,11,28,8,0);
		Date expectedend = getDate(2018,11,28,10,21);
		assertEquals("Changed start from null, testing start", expectedstart.toString(), c.getStart());
		assertEquals("Changed start from null, testing end", expectedend.toString(), c.getEnd());			
	}

	@Test
	public void test_setter_and_getter_start_toLaterThanend(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,10,21));
		c.setStart(getDate(2018,11,29,8,0));
		Date expectedstart = getDate(2018,11,28,10,20);
		Date expectedend = getDate(2018,11,28,10,21);
		assertEquals("Changed start to later than end, expected unchanged start, testing start", expectedstart.toString(), c.getStart());
		assertEquals("Changed start to later than end, testing end", expectedend.toString(), c.getEnd());			
	}

	@Test
	public void test_setter_and_getter_start_Nullend(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), null);
		c.setStart(getDate(2018,11,28,8,0));
		Date expectedstart = getDate(2018,11,28,8,0);
		assertEquals("Changed start to 8am from 10:20am, testing start", expectedstart.toString(), c.getStart());
		assertEquals("Changed start to 8am from 10:20am, testing end", "", c.getEnd());			
	}

	@Test
	public void test_setter_and_getter_start_setterEncapsulation(){
		testClassDefinition();
		Date dep = getDate(2019,11,28,10,20);
		TripComponent c = new TripComponent(dep, getDate(2019,11,28,11,21));

		dep.setTime(getDate(2018,11,28,8,0).getTime());

		Date expectedstart = getDate(2019,11,28,10,20);
		assertEquals("Changed start time provided as argument to setstart to 2018 from 2019, testing that start in TripComponent unchanged", expectedstart.toString(), c.getStart());
	}

	@Test
	public void test_setter_and_getter_end_NewendAfterstart(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,10,21));
		c.setEnd(getDate(2018,11,29,8,0));
		Date expectedstart = getDate(2018,11,28,10,20);
		Date expectedend = getDate(2018,11,29,8,0);
		assertEquals("Changed end to 8am on the 29th from 10:21am on the 28th, testing start", expectedstart.toString(), c.getStart());
		assertEquals("Changed end to 8am on the 29th from 10:21am on the 28th", expectedend.toString(), c.getEnd());			
	}

	@Test
	public void test_setter_and_getter_end_fromNullend(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,21), null);
		c.setEnd(getDate(2018,11,29,8,0));
		Date expectedstart = getDate(2018,11,28,10,21);
		Date expectedend = getDate(2018,11,29,8,0);
		assertEquals("Changed end from null, testing start", expectedstart.toString(), c.getStart());
		assertEquals("Changed end from null, testing end", expectedend.toString(), c.getEnd());			
	}

	@Test
	public void test_setter_and_getter_end_toEarlierThanstart(){
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,10,21));
		c.setEnd(getDate(2018,11,27,8,0));
		Date expectedstart = getDate(2018,11,28,10,20);
		Date expectedend = getDate(2018,11,28,10,21);
		assertEquals("Changed start to later than end, testing start", expectedstart.toString(), c.getStart());
		assertEquals("Changed start to later than end, expected unchanged end, testing end", expectedend.toString(), c.getEnd());			
	}

	@Test
	public void test_setter_and_getter_end_Nullstart(){
		testClassDefinition();
		TripComponent c = new TripComponent(null, getDate(2018,11,28,10,20));
		c.setEnd(getDate(2018,11,28,8,0));
		Date expectedend = getDate(2018,11,28,8,0);
		assertEquals("Changed end to 8am from 10:20am, testing end", expectedend.toString(), c.getEnd());
		assertEquals("Changed end to 8am from 10:20am, testing start", "", c.getStart());			
	}

	@Test
	public void test_length_startOneMinuteBeforeend() {
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,10,21));
		long expectedLength = 1;
		assertEquals("TripComponent is one minute long", 60,c.lengthInSeconds());

	}

	@Test
	public void test_length_startOneHourBeforeend() {
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,11,20));
		long expectedLength = 3600;
		assertEquals("TripComponent is one hour long", expectedLength,c.lengthInSeconds());

	}

	@Test
	public void test_length_startNull() {
		testClassDefinition();
		TripComponent c = new TripComponent(null, getDate(2018,11,28,11,20));
		long expectedLength = 0;
		assertEquals("Null start", expectedLength,c.lengthInSeconds());

	}

	@Test
	public void test_length_endNull() {
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,11,20), null);
		long expectedLength = 0;
		assertEquals("Null end", expectedLength,c.lengthInSeconds());

	}
	
	@Test
	public void test_getDuration_startOneHourBeforeEnd() {
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,11,20));
		String expectedDuration = "3600 seconds";
		assertEquals("TripComponent is one hour long", expectedDuration, c.getDuration());		
	}

	@Test
	public void test_getDuration_endNull() {
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), null);
		String expectedDuration = "0 seconds";
		assertEquals("TripComponent is unknown (null end) long", expectedDuration, c.getDuration());		
	}
	
	@Test
	public void test_toString_endNull() {
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), null);
		String expectedString = "Start: Fri Dec 28 10:20:00 MST 2018\tEnd: \tLength: 0 seconds";
		assertEquals("Expecting format: 'Start: <date as string><tab>End: <date as string><tab>Length: <duration>'", expectedString, c.toString());		
	}
	
	@Test
	public void test_toString_startOneHourBeforeEnd() {
		testClassDefinition();
		TripComponent c = new TripComponent(getDate(2018,11,28,10,20), getDate(2018,11,28,11,20));
		String expectedString = "Start: Fri Dec 28 10:20:00 MST 2018\tEnd: Fri Dec 28 11:20:00 MST 2018\tLength: 3600 seconds";
		assertEquals("Expecting format: 'Start: <date as string><tab>End: <date as string><tab>Length: <duration>'", expectedString, c.toString());		
	}	
}