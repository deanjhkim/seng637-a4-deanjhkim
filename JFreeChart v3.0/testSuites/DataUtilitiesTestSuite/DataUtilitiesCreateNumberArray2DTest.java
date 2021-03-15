package DataUtilitiesTestSuite;


import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesCreateNumberArray2DTest {

	@Test
	// Equivalent Class test
	// data: 2x3 array of positive values
	public void testPositiveArrayCreateNumberArray2D() {

		double[][] input = new double[][] { { 1.1, 2.2, 3.3 }, { 1.0, 2.0, 3.0 } };

		try {
			Number[][] result = DataUtilities.createNumberArray2D(input);
			assertArrayEquals(new Number[][] { { 1.1, 2.2, 3.3 }, { 1.0, 2.0, 3.0 } }, result);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}

	@Test
	// Equivalent Class test
	// data: 2x3 array of negative values
	public void testNegativeArrayCreateNumberArray2D() {

		double[][] input = new double[][] { { -1.1, -2.2, -3.3 }, { -1.0, -2.0, -3.0 } };

		try {
			Number[][] result = DataUtilities.createNumberArray2D(input);
			assertArrayEquals(new Number[][] { { -1.1, -2.2, -3.3 }, { -1.0, -2.0, -3.0 } }, result);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	@Test
	// Boundary Case test
	// data: 1x1 array with positive value
	public void testSingleELementeArrayCreateNumberArray2D() {

		double[][] input = new double[][] { {1.1} };

		try {
			Number[][] result = DataUtilities.createNumberArray2D(input);
			assertArrayEquals(new Number[][] { {1.1} }, result);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}

	@Test
	// Worst Case test
	// data: empty array
	public void testEmptyArrayCreateNumberArray2D() {

		double[][] input = new double[][] {};

		try {
			Number[][] result = DataUtilities.createNumberArray2D(input);
			assertArrayEquals(new Number[][] {}, result);
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}
	
	@Test
	//Robustness Test
	// data: null
	public void testNullArrayCreateNumberArray2D() {

		double[][] input = null;

		try {
			Number[][] result = DataUtilities.createNumberArray2D(input);
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail("Exception: " + e);
		}
	}

}
