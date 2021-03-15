package DataUtilitiesTestSuite;


import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesCreateNumberArrayTest {

	@Test
	// Equivalent Class test
	// data: multi-array of positive values
	public void testPositiveArrayCreateNumberArray() {

		double[] input = new double[] { 1.1, 2.2, 3.3 };

		try {
			Number[] result = DataUtilities.createNumberArray(input);
			assertArrayEquals(new Number[] { 1.1 , 2.2, 3.3}, result);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	@Test
	// Equivalent Class test
	// data: multi-array of negative values
	public void testNegativeArrayCreateNumberArray() {

		double[] input = new double[] { -1.1, -2.2, -3.3 };

		try {
			Number[] result = DataUtilities.createNumberArray(input);
			assertArrayEquals(new Number[] { -1.1 , -2.2, -3.3}, result);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	@Test
	// Boundary Case test
	// data: single element array with positive value
	public void testSingleELementeArrayCreateNumberArray() {

		double[] input = new double[] { 1.1 };

		try {
			Number[] result = DataUtilities.createNumberArray(input);
			assertArrayEquals(new Number[] { 1.1}, result);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	
	@Test
	// Worst Case test
	// data: empty array
	public void testEmptyArrayCreateNumberArray() {

		double[] input = new double[] {};

		try {
			Number[] result = DataUtilities.createNumberArray(input);
			assertArrayEquals(new Number[] {}, result);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	@Test
	//Robustness Test
	// data: null
	public void testNullArrayCreateNumberArray() {

		double[] input = null;

		try {
			Number[] result = DataUtilities.createNumberArray(input);
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
}
