package RangeTestSuite;


import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandToIncludeTest {

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
	//range: a valid range object
	//value: a valid double not in the initial range
	public void expandToIncludeValueOutsideRange() {
		range1 = Range.expandToInclude(range1, 200);
		
		assertEquals("The lower bound of the range should be -100",
		-100, range1.getLowerBound(), 000000001d);
		
		if (range1.getUpperBound() == range1.getLowerBound()) {
			fail("Range class getUpperBound method is flawed and returns lower bound, test failed - no way to obtain expanded range's upper boundary");
		}
		else {
			assertEquals("The upper bound of the range should be 200",
					200, range1.getUpperBound(), 000000001d);
		}
	}
	
	@Test
	//Equivalent class test
	//range: a valid range object
	//value: a valid double not in the initial range less than the lower bound
	public void expandToIncludeValueOutsideRangeLesser() {
		range1 = Range.expandToInclude(range1, -200);
		assertEquals("The lower bound of the range should be -200",
		-200, range1.getLowerBound(), 000000001d);
		
		if (range1.getUpperBound() == range1.getLowerBound()) {
			fail("Range class getUpperBound method is flawed and returns lower bound, test failed - no way to obtain expanded range's upper boundary");
		}
		else {
			assertEquals("The upper bound of the range should be 100",
					100, range1.getUpperBound(), 000000001d);
		}
	}
	
	
	@Test
	//Robustness class test
	//range: a valid range object
	//value: a valid double in the initial range
	public void expandToIncludeValueAlreadyInsideRange() {
		Range.expandToInclude(range2, 150);
		assertEquals("The lower bound of the range should be 101",
		101, range2.getLowerBound(), 000000001d);
		
		if (range2.getUpperBound() == range2.getLowerBound()) {
			fail("Range class getUpperBound method is flawed and returns lower bound, test failed - no way to obtain expanded range's upper boundary");
		}
		else {
			assertEquals("The upper bound of the range should be 200",
					200, range2.getUpperBound(), 000000001d);
		}
	}
	
	@Test
	//Worst case test
	//range: a range object with undeclared boundaries
	//value: a valid double
	public void expandToIncludeRangeUndeclared() {
		try {
		range4 = Range.expandToInclude(range4, 99);
		assertEquals("The lower bound of the range should be 99",
				99, range4.getLowerBound(), 000000001d);
		
		assertEquals("The upper bound of the range should be 99",
				99, range4.getUpperBound(), 000000001d);
		}
		catch (Exception e){
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
