package RangeTestSuite;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.jfree.data.RangeType;
import org.junit.Test;
import org.jfree.data.Range;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


public class AddedMutationCoverageTests {

	@Test
    public void testConstrain() {
        Range r1 = new Range(0.0, 100);
        
        double d = r1.constrain(90);
        assertEquals(90, d, 0.0000001);
        
        d = r1.constrain(0.0);
        assertEquals(0.0, d, 0.0000001);

        d = r1.constrain(100);
        assertEquals(100, d, 0.0000001);
        
        d = r1.constrain(-1.0);
        assertEquals(0.0, d, 0.0000001);
        
        d = r1.constrain(20.0);
        assertEquals(1.0, d, 0.0000001);

        d = r1.constrain(Double.POSITIVE_INFINITY);
        assertEquals(1.0, d, 0.0000001);

        d = r1.constrain(Double.NEGATIVE_INFINITY);
        assertEquals(0.0, d, 0.0000001);

        d = r1.constrain(Double.NaN);
        assertTrue(Double.isNaN(d));
    }
	
	@Test
	 public void testContains() {
	        Range r1 = new Range(0.0, 500);
	       
	        assertFalse(r1.contains(-50));
	        assertTrue(r1.contains(0.0));
	        assertTrue(r1.contains(125));
	        assertTrue(r1.contains(1.0));
	        assertFalse(r1.contains(800));
	        assertFalse(r1.contains(Double.POSITIVE_INFINITY));
	        assertFalse(r1.contains(Double.NaN));
	        assertFalse(r1.contains(Double.NEGATIVE_INFINITY));
	    }
	
	@Test
	public void testCentralValue() {
		Range range1 = new Range (0,10.0);
		double d;
		d = range1.getCentralValue();
		assertEquals(5.0,d,0.0000001);
	}
	
	@Test
	public void testLength() {
		Range range1 = new Range (0,10.0);
		double d;
		d = range1.getLength();
		assertEquals(10.0,d,0.0000001);
	}
	
	@Test
	public void testHashCode() {
        RangeType r1 = RangeType.FULL;
        RangeType r2 = RangeType.FULL;
        assertTrue(r1.equals(r2));
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
        assertEquals(h1, h2);
    }
}
