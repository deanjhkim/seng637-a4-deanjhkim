package RangeTestSuite;


import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShiftRangeDoubleZeroCrossingTestCase {

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
	//delta: a valid double to shift the range by
	//allowZeroCrossing: true, boolean - range will be shifted across zero with no modifications
	public void shiftWithZeroCrossing() {
		Range.shift(range1, 200, true);
		assertEquals("The lower bound of the range should be 100",
		100, range1.getLowerBound(), 000000001d);
		
		if (range1.getUpperBound() == range1.getLowerBound()) {
			fail("Range class getUpperBound method is flawed and returns lower bound, test failed - no way to obtain expanded range's upper boundary");
		}
		else {
			assertEquals("The upper bound of the range should be 300",
					300, range1.getUpperBound(), 000000001d);
		}
	}
	
	@Test
	//Equivalent class test
	//range: a valid range object
	//delta: a valid double to shift the range by
	//allowZeroCrossing: false, boolean - any bound that crosses the zero mark after shifting will become zero
	public void shiftNoZeroCrossing() {
		Range.shift(range1, 200, false);
		assertEquals("The lower bound of the range should be 0",
		0, range1.getLowerBound(), 000000001d);
		
		if (range1.getUpperBound() == range1.getLowerBound()) {
			fail("Range class getUpperBound method is flawed and returns lower bound, test failed - no way to obtain expanded range's upper boundary");
		}
		else {
			assertEquals("The upper bound of the range should be 300",
					300, range1.getUpperBound(), 000000001d);
		}
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

}
