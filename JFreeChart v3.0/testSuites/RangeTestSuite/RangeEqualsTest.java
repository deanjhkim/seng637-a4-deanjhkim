package RangeTestSuite;


import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeEqualsTest {

	private Range range1;
	private Range range2;
	private Range range3;
	private Range range4;
	

	
	@Before 
	public void setUp() throws Exception {
		range1 = new Range (-100, 100);
		range2 = new Range (101, 200);
		range3 = new Range (180,280);
		
	}
	
	@Test
	//Equivalent class test
	//Object: object to test range against
	public void equalsSameObject() {
		range1.equals(range1);
	}
	

	@Test
	//Equivalent class test
	//Object: object to test range against
	public void equalsDifferentRangeObject() {
		range1.equals(range2);
	}
	
	@Test
	//Equivalent class test
	//Object: object to test range against
	public void equalsNotARangeObject() {
		int x= 5;
		range1.equals(x);
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

}
