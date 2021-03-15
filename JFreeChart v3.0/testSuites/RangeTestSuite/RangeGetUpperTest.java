package RangeTestSuite;


import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeGetUpperTest {

	private Range range1;
	private Range range2;
	private Range range3;
	private Range range4;
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before 
	public void setUp() throws Exception {
		range1 = new Range (-100, 100);
		range2 = new Range (101, 200);
		range3 = new Range (180,280);
	}
	
	@Test
	//Equivalent class test
	//Check the upper bound of a valid range and verify if it's correct
	public void getUpperBoundPasses() {
		assertEquals("The upper bound of the range should be 200",
		200, range2.getUpperBound(), 000000001d);
	}
	
	//Equivalent class test
	//Check the upper bound of a valid range and verify if it's correct
	public void getUpperBoundPasses2() {
		assertEquals("The upper bound of the range should be 100",
		100, range1.getUpperBound(), 000000001d);
	}
	
	@Test 
	//Boundary value test
	//Test whether the returned upper boundary is greater than 0.00001 less than the boundary and less than 0.00001 more than the boundary.
	public void getUpperBoundBoundaries() {
		assertTrue("This value should be greater than the upper bound of 100",
			(100+0.00001) > range1.getUpperBound()	);
		assertTrue("This value should be less than the upper bound of 100",
				(100-0.00001) < range1.getUpperBound()	);
		
	}
	
	@Test 
	//Robustness test
	//Check the upper boundary of a range object without declared boundaries.
	public void getUpperBoundUndeclared() {
		try {
		assertNull("The undeclared range should have a null upper boundary",
			range4.getUpperBound()	);
		}
		catch (NullPointerException e){
			fail("Exception: " + e);
		}
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
}
