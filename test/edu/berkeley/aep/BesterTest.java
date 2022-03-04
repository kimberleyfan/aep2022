package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BesterTest {
    @Test
    public void bestOfFourTeaspoonsAndOneOzShouldBeOneOz() {
        var fourTsp = new ArithmeticQuantity(4, Unit.TSP);
        var oneOz = new ArithmeticQuantity(1, Unit.OZ);
        var bester = new Bester(fourTsp, oneOz);
        assertEquals(oneOz, bester.best());
    }
}
