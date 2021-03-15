package DataUtilitiesTestSuite;


import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesCalculateColumnTotalTest {

	@Test
	// Equivalent Class test
	// data: nominal object with positive values
	// column: valid number within specified range
	public void testPositiveValuesCalculateColumnTotal() {
		Mockery context = new Mockery();
		final Values2D values = context.mock(Values2D.class);
		context.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 1);
				will(returnValue(8.9));
				one(values).getValue(1, 1);
				will(returnValue(2.1));
			}
		});

		try {
			double result = DataUtilities.calculateColumnTotal(values, 1);
			assertEquals(result, 11.0, .000000001d);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}

	@Test
	// Equivalent Class test
	// data: nominal object with negative values
	// column: valid number within specified range
	public void testNegativeValuesCalculateColumnTotal() {
		Mockery context = new Mockery();
		final Values2D values = context.mock(Values2D.class);
		context.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 1);
				will(returnValue(-10.0));
				one(values).getValue(1, 1);
				will(returnValue(-5.5));
			}
		});

		try {
			double result = DataUtilities.calculateColumnTotal(values, 1);
			assertEquals(result, -15.5, .000000001d);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	@Test
	// Boundary Value test
	// data: nominal object with negative values
	// column: 0, valid boundary input
	public void testZeroColumnCalculateColumnTotal() {
		Mockery context = new Mockery();
		final Values2D values = context.mock(Values2D.class);
		context.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(-10.0));
				one(values).getValue(1, 0);
				will(returnValue(-5.5));
			}
		});

		try {
			double result = DataUtilities.calculateColumnTotal(values, 0);
			assertEquals(result, -15.5, .000000001d);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	@Test
	// Worst Case test
	// data: nominal object with empty matrix (no rows)
	// column: N/A
	public void testEmptyDataCalculateColumnTotal() {
		Mockery context = new Mockery();
		final Values2D values = context.mock(Values2D.class);
		context.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(0));
			}
		});

		try {
			double result = DataUtilities.calculateColumnTotal(values, 0);
			assertEquals(result, 0, .000000001d);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}

	@Test
	// Robustness test
	// data: nominal object with null values
	// column: valid number within specified range
	public void testNullCalculateColumnTotal() {
		Mockery context = new Mockery();
		final Values2D values = context.mock(Values2D.class);
		context.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 1);
				will(returnValue(null));
				one(values).getValue(1, 1);
				will(returnValue(2.2));
				one(values).getValue(2, 1);
				will(returnValue(null));
			}
		});

		try {
			double result = DataUtilities.calculateColumnTotal(values, 1);
			assertEquals(2.2, result, .000000001d);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

	}
	
//	@Test
//	// Robustness test
//	// data: nominal object, returns index out of bounds
//	// column: -1, invalid number
//	public void testNegativeRowCalculateColumnTotal() {
//		Mockery context = new Mockery();
//		final Values2D values = context.mock(Values2D.class);
//		context.checking(new Expectations() {
//			{
//				one(values).getRowCount();
//				will(returnValue(2));
//				one(values).getValue(0, -1);
//				will(throwException(new IndexOutOfBoundsException()));
//				one(values).getValue(1, -1);
//				will(throwException(new IndexOutOfBoundsException()));
//			}
//		});
//
//		try {
//			double result = DataUtilities.calculateColumnTotal(values, -1);
//			assertEquals(result, 0.0, .000000001d);
//		} catch (Exception e) {
//			fail("Exception: " + e);
//		}
//	}

//	@Test
//	// Robustness test
//	// data: nominal object, returns index out of bounds
//	// column: 3, invalid number out of range
//	public void testRowOutOfRangeRowCalculateColumnTotal() {
//		Mockery context = new Mockery();
//		final Values2D values = context.mock(Values2D.class);
//		context.checking(new Expectations() {
//			{
//				one(values).getRowCount();
//				will(returnValue(2));
//				one(values).getValue(0, 3);
//				will(throwException(new IndexOutOfBoundsException()));
//				one(values).getValue(1, 3);
//				will(throwException(new IndexOutOfBoundsException()));
//			}
//		});
//
//		try {
//			Double result = DataUtilities.calculateColumnTotal(values, 3);
//			assertEquals(result, 0.0, .000000001d);
//		} catch (Exception e) {
//			fail("Exception: " + e);
//		}
//	}
//
}
