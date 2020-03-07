import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class CreditHistoryTest{
	@Test
	public void test_addRating() {
		CreditHistory c = new CreditHistory();
		int a = 5;
		c.addRating(a);
		ArrayList<Integer> s = c.getRatings();
		assertEquals("add 5 to ratings", 5, s.get(0), 0.00001);
	}
	
	@Test
	public void test_addRating2() {
		CreditHistory c = new CreditHistory();
		int a = -5;
		c.addRating(a);
		ArrayList<Integer> s = c.getRatings();
		assertEquals("add -5 to ratings", -5, s.get(0), 0.00001);
	}
		
	@Test
	public void test_trimRatings(){
		CreditHistory c = new CreditHistory();
		int[] b = new int[11];
		for(int i = 0;i<b.length;i++){
			c.addRating(b[i]);
		}	
		c.trimRatings();
		ArrayList<Integer> s = c.getRatings();
		assertEquals("add 10 integers", 10, s.size(), 0.00001);
	}	
	
	@Test
	public void test_numOfRating(){
		CreditHistory c = new CreditHistory();
		int a = 5;
		c.addRating(a);
		ArrayList<Integer> s = c.getRatings();
		assertEquals("size is one", 1, s.size(), 0.00001);
		
	}		
}