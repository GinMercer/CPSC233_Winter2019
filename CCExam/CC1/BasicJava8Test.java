import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;

public class BasicJava8Test
{

	private String filename = "BasicJava8.java";

	private boolean usesLibrary(String libraryName)
	{
		boolean usesLibrary = false;

		try
		{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line!= null && !usesLibrary)
			{
				if (line.contains(libraryName))
				{
					usesLibrary = true;
				}
				line = in.readLine();
			}
			in.close();
		}
		catch(FileNotFoundException e)
		{
			//do nothing
		}
		catch(IOException e)
		{
			//do nothing
		}
		return usesLibrary;

	}

	@Test
	public void test_usedLibraries()
	{
		assertFalse("Math not allowed",usesLibrary("Math"));
		assertFalse("Float not allowed",usesLibrary("Float"));
		assertFalse("Integer not allowed",usesLibrary("Integer"));
		assertFalse("Character not allowed",usesLibrary("Character"));
		assertFalse("StringBuilder not allowed",usesLibrary("StringBuilder"));
	}

	@Test
	public void test_power_2_2()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertEquals("Testing 2 to the power 2 :",4.0,BasicJava8.power(2,2),0.0001);
	}

	@Test
	public void test_power_3point3_0()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertEquals("Testing 3.3 to the power 0 :",1.0,BasicJava8.power(3.3f,0),0.0001);
	}

	@Test
	public void test_power0_0()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertEquals("Testing 0 to the power 0 :",1.0,BasicJava8.power(0,0),0.0001);
	}

	@Test
	public void test_powerminus5point2_3()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertEquals("Testing -5.2 to the power 3 :",-140.6079,BasicJava8.power(-5.2f,3),0.0001);
	}

	@Test
	public void test_power1point7_minus4()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertEquals("Testing 1.7 to the power -4 :",0.1197,BasicJava8.power(1.7f,-4),0.0001);
	}

	@Test
	public void test_isPrime_1()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertTrue(" 1 is a prime number. You said No ",BasicJava8.isPrime(1));
	}

	@Test
	public void test_isPrime_29()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertTrue(" 29 is a prime number. You said No ",BasicJava8.isPrime(29));
	}

	@Test
	public void test_isPrime_59()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertTrue(" 59 is a prime number. You said No ",BasicJava8.isPrime(59));
	}

	@Test
	public void test_isPrime_27()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse(" 27 is not a prime number. You said the opposite  ",BasicJava8.isPrime(27));
	}

	@Test
	public void test_isPrime_51()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse(" 51 is not a prime number. You said the opposite ",BasicJava8.isPrime(51));
	}


	@Test
	public void test_formatDate_010119()
	{   
		assertEquals("formatDate(01/01/19)","01.01.19",BasicJava8.formatDate("01/01/19"));
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("StringBuiler"));
	}

	@Test
	public void test_formatDate_012819()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("StringBuilder"));
		assertEquals("formatDate(01/28/19)","28.01.19",BasicJava8.formatDate("01/28/19"));
	}

	@Test
	public void test_formatDate_leadingSpace()
	{
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("StringBuilder"));
		assertEquals("formatDate( 02/01/19)","01.02.19",BasicJava8.formatDate(" 02/01/19"));
	}

	@Test
	public void test_formatDate_spaceBeforeAndAfter()
	{			
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("StringBuilder"));
		assertEquals("formatDate( 04/01/19 8)","01.04.19",BasicJava8.formatDate(" 04/01/19 "));
	}

        @Test
        public void test_formatDate_spacesBeforeAfterAndWithin()
        {
                assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("StringBuilder"));
                assertEquals("formatDate( 04  /01 / 19 )","01.04.19",BasicJava8.formatDate(" 04  /01 / 19 "));
        }

	@Test
	public void test_round_afterDecimalIsZero() {
		
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		int expected = 15;
		int actual = BasicJava8.round(15.0);
		
		assertEquals("Rounding 15.0", expected, actual);
	}

	@Test
	public void test_round_roundUpNegativeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		int expected = -1876;
		int actual = BasicJava8.round(-1876.264);
		
		assertEquals("Rounding -1876.764", expected, actual);
	}

	@Test
	public void test_round_downToZero() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		int expected = 0;
		int actual = BasicJava8.round(0.123456789);
		
		assertEquals("Rounding 0.123456789", expected, actual);
	}

	@Test
	public void test_round_RoundUp() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		int expected = 1235;
		int actual = BasicJava8.round(1234.5);
		
		assertEquals("Rounding 1234.5", expected, actual);
	}
	
}

