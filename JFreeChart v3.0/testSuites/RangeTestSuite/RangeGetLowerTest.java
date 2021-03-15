package RangeTestSuite;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeGetLowerTest {
	
	
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
	//Check the lower bound of a valid range and verify if it's correct
	public void getLowerBoundPasses() {
		assertEquals("The lower bound of the range should be 101",
		101, range2.getLowerBound(), 000000001d);
	}
	
	@Test
	//Equivalent class test
	//Check the lower bound of a valid range and verify if it's correct
	public void getLowerBoundPasses2() {
		assertEquals("The lower bound of the range should be -100",
		-100, range1.getLowerBound(), 000000001d);
	}
	
	@Test 
	//Boundary value test
	//Test whether the returned upper boundary is greater than 0.00001 less than the boundary and less than 0.00001 more than the boundary.
	public void getLowerBoundBoundaries() {
		assertTrue("This value should be greater than the lower bound of -100",
			(-100+0.00001) > range1.getLowerBound()	);
		assertTrue("This value should be less than the lower bound of -100",
				(-100-0.00001) < range1.getLowerBound()	);
		
	}
	
	@Test 
	//Robustness test
	//Check the lower boundary of a range object without declared boundaries.
	public void getLowerBoundUndeclared() {
		try {
		assertNull("The undeclared range should have a null upper boundary",
			range4.getLowerBound()	);
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
