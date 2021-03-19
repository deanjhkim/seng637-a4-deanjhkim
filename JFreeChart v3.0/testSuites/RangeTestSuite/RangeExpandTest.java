package RangeTestSuite;


import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeExpandTest {

	private Range range1;
	private Range range2;
	private Range range3;
	private Range range4;
	private Range range5;
	private Range range6;
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		range1 = new Range (0, 100);
		range2 = new Range (0, 100);
		range3 = new Range (180,280);
		
	}
	
	@Test
	//Equivalent class test
	//range: a valid range object
	//lowerMargin: a positive decimal double
	//upperMargin: a positive decimal double
	public void expandRange() {
		range1 = Range.expand(range1, 0.01, 0.99);
		assertEquals("The lower bound of the range should be -1",
		-1, range1.getLowerBound(), 000000001d);
		if (range1.getUpperBound() == range1.getLowerBound()) {
			fail("Range class getUpperBound method is flawed and returns lower bound, test failed - no way to obtain expanded range's upper boundary");
		}
		else {
			assertEquals("The upper bound of the range should be 199",
			199, range1.getUpperBound(), 000000001d);
		}
		
	}
	
	
	@Test
	//Equivalent class test
	//using example from Range documentation
	//range: a valid range object
	//lowerMargin: a positive decimal double
	//upperMargin: a positive decimal double
	public void expandRangeDocumented() {
		range4 = Range.expand(new Range(2, 6), 0.25, 0.5);
		assertEquals("The lower bound of the range should be 1",
		1, range4.getLowerBound(), 000000001d);
		assertEquals("The upper bound of the range should be 8",
		8, range4.getUpperBound(), 000000001d);
		
	}
	
	@Test
	//Robustness test
	//range: a valid range object
	//lowerMargin: a negative decimal double
	//upperMargin: a positive decimal double
	public void expandRangeNegativeMargins() {
		range5 = Range.expand(new Range(2, 6), -0.25, 0.5);
		assertEquals("The lower bound of the range should be 3",
		3, range5.getLowerBound(), 000000001d);
		
		if (range5.getUpperBound() == range5.getLowerBound()) {
			fail("Range class getUpperBound method is flawed and returns lower bound, test failed - no way to obtain expanded range's upper boundary");
		}
		else {
			assertEquals("The upper bound of the range should be 8",
					8, range5.getUpperBound(), 000000001d);
		}
	}
	
	@Test
	//Worst case test
	//range: a range object with undeclared boundaries
	//lowerMargin: a positive decimal double
	//upperMargin: a positive decimal double
	public void expandRangeUndeclared() {
		try {
		range6 = Range.expand(range6, 0.1, 0.9);
		}
		catch (Exception e){
			System.out.println(e);
		}
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
}
