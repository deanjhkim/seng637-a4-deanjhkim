package DataUtilitiesTestSuite;


import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesCumulativePercentagesTest {
	
	@Test
	// Equivalent Class test
	// data: multiple key value pairs with positive value
	public void testMultipleValuesCumulativePercentages() {
		
		Mockery context = new Mockery();
		
		final KeyedValues values = context.mock(KeyedValues.class);
		
		context.checking(new Expectations() {
			{
				allowing(values).getItemCount();
				will(returnValue(3));	
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(0);
				will(returnValue(5.0));
				allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getValue(1);
				will(returnValue(9.0));
				allowing(values).getKey(2);
				will(returnValue(2));
				allowing(values).getValue(2);
				will(returnValue(2.0));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals(0.3125, result.getValue(0));
		assertEquals(0.875, result.getValue(1));
		assertEquals(1.0, result.getValue(2));
	}
	
	@Test
	// Boundary Case test
	// data: a single key value pair with positive value
	public void testSingleValueCumulativePercentages() {
		
		Mockery context = new Mockery();
		
		final KeyedValues values = context.mock(KeyedValues.class);
		
		context.checking(new Expectations() {
			{
				allowing(values).getItemCount();
				will(returnValue(1));	
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(0);
				will(returnValue(2.5));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals(1.0, result.getValue(0));
	}
	
	@Test
	// Worst Case test
	// data: a single key value pair with a 0 value
	public void testSingleZeroValueCumulativePercentages() {
		
		Mockery context = new Mockery();
		
		final KeyedValues values = context.mock(KeyedValues.class);
		
		context.checking(new Expectations() {
			{
				allowing(values).getItemCount();
				will(returnValue(1));	
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(0);
				will(returnValue(0));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertTrue(((Double) result.getValue(0)).isNaN());
	}
	
	@Test
	// Robustness test
	// data: single key value pairs with a single null value.
	public void testNullValueCumulativePercentages() {
		
		Mockery context = new Mockery();
		
		final KeyedValues values = context.mock(KeyedValues.class);
		
		context.checking(new Expectations() {
			{
				allowing(values).getItemCount();
				will(returnValue(1));	
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(0);
				will(returnValue(null));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertTrue(((Double) result.getValue(0)).isNaN());
	}
	
	@Test
	// Robustness test
	// data: multiple key value pairs with a single null value.
	public void testMultipleNullValuesCumulativePercentages() {
		
		Mockery context = new Mockery();
		
		final KeyedValues values = context.mock(KeyedValues.class);
		
		context.checking(new Expectations() {
			{
				allowing(values).getItemCount();
				will(returnValue(3));	
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(0);
				will(returnValue(5.0));
				allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getValue(1);
				will(returnValue(null));
				allowing(values).getKey(2);
				will(returnValue(2));
				allowing(values).getValue(2);
				will(returnValue(5.0));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals(0.5, result.getValue(0));
		assertEquals(0.5, result.getValue(1));
		assertEquals(1.0, result.getValue(2));
	}
	
//	@Test
	// Robustness test
	// data: no key value pairs
//	public void testNoKeysCumulativePercentages() {
//		
//		Mockery context = new Mockery();
//		
//		final KeyedValues values = context.mock(KeyedValues.class);
//		
//		context.checking(new Expectations() {
//			{
//				allowing(values).getItemCount();
//				will(returnValue(0));	
//			}
//		});
//		
//		try {
//		KeyedValues result = DataUtilities.getCumulativePercentages(values);
//		assertEquals(0, result.getValue(0));
//		} catch (Exception e) {
//			fail("Exception: " + e);
//		}
//	}
//	
	@Test
	// Robustness test
	// data: no key value pairs
	public void testNullCumulativePercentages() {
		
		
		try {
		KeyedValues result = DataUtilities.getCumulativePercentages(null);
		} catch (IllegalArgumentException e) { 
		
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
}
