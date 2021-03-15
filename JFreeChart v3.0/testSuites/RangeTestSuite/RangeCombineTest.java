package RangeTestSuite;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;


public class RangeCombineTest {

	private Range range1;
	private Range range2;
	private Range range3;
	private Range range4;
	private Range range5;
	private Range range6;
	
	private Range combined1;
	private Range combined2;
	private Range combined3;
	private Range combined4;
	private Range combined5;
	
	
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
	// Equivalent class test
	//Ranges being combined do not overlap
	//range1: valid range object, upper boundary less than lower boundary of range2
	//range2: valid range object, lower boundary greater than upper boundary of range1
	public void combineNewRangeNoOverlap() {
		try {
		combined1 = Range.combine(range1, range2);
		assertEquals("The lower bound of the combined range should be -100",
				-100, combined1.getLowerBound(), 000000001d);
		assertEquals("The upper bound of the combined range should be 200",
				200, combined1.getUpperBound(), 000000001d);
		}
		catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	
	
	@Test
	// Equivalent class test
	//Ranges being combined do not overlap, input order of ranges to combine function is switched
	//range1: valid range object, upper boundary less than lower boundary of range2
	//range2: valid range object, lower boundary greater than upper boundary of range1
	public void combineNewRangeNoOverlapSwitched() {
		
		combined4 = Range.combine(range2, range1);
		assertEquals("The lower bound of the combined range should be -100",
				-100, combined4.getLowerBound(), 000000001d);
		assertEquals("The upper bound of the combined range should be 200",
				200, combined4.getUpperBound(), 000000001d);
	}
	
	@Test 
	// Equivalent class test
	//Ranges being combined overlap
	//range1: valid range object, upper boundary greater than lower boundary of range2
	//range2: valid range object, lower boundary less than upper boundary of range1
	public void combineNewRangeOverlap() {
		
		try {
		combined2 = Range.combine(range2, range3);
		assertEquals("The lower bound of the combined range should be 101",
				101, combined2.getLowerBound(), 000000001d);
		assertEquals("The upper bound of the combined range should be 280",
				280, combined2.getUpperBound(), 000000001d);
		}
		catch (Exception e){
			fail("Exception: " + e);
		}
	}
	
	@Test
	// Equivalent class test
	//Ranges being combined overlap, input order of ranges to combine function is switched
	//range1: valid range object, upper boundary greater than lower boundary of range2
	//range2: valid range object, lower boundary less than upper boundary of range1
	public void combineNewRangeOverlapSwitched() {
		combined3 = Range.combine(range3, range2);
		assertEquals("The lower bound of the combined range should be 101",
				101, combined3.getLowerBound(), 000000001d);
		assertEquals("The upper bound of the combined range should be 280",
				280, combined3.getUpperBound(), 000000001d);
	}
	
	@Test
	// Robustness test
	//One range is valid, one is null
	//range1: valid range object
	//range2: null range object
	public void combineOneNullRange() {
		combined4 = Range.combine(range1, range4);
		assertEquals("The lower bound of the combined range should be -100",
				-100, combined4.getLowerBound(), 000000001d);
		assertEquals("The upper bound of the combined range should be 100",
				100, combined4.getUpperBound(), 000000001d);
	}
	
	@Test 
	// Worst case test
	//Ranges being combined are both undeclared
	//range1: valid range object, upper boundary greater than lower boundary of range2
	//range2: valid range object, lower boundary less than upper boundary of range1
	public void combineTwoNullRange() {
		
		try {
		combined5 = Range.combine(range5, range6);
		assertEquals("The lower boundary of the range is null",
				null, combined5.getLowerBound());
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
