package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuantityTest {
    @Test
    public void twelveInchesShouldEqualOneFoot() {
        var twelveInches = new Quantity(12, Unit.INCH);
        var oneFoot = new Quantity(1, Unit.FOOT);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void threeFeetShouldEqualOneYard() {
        var threeFeet = new Quantity(3, Unit.FOOT);
        var oneYard = new Quantity(1, Unit.YARD);
        assertEquals(threeFeet, oneYard);
    }

    @Test
    public void oneMileShouldEqual1760yards() {
        var one760Yard = new Quantity(1760, Unit.YARD);
        var oneMile = new Quantity(1, Unit.MILE);
        assertEquals(one760Yard, oneMile);
    }

    @Test
    public void oneTablespoonShouldEqualThreeTeaspoons() {
        var oneTbsp = new Quantity(1, Unit.TBSP);
        var threeTsp = new Quantity(3, Unit.TSP);
        assertEquals(oneTbsp, threeTsp);
    }

    @Test
    public void oneOzShouldEqualTwoTbsp() {
        var oneOz = new Quantity(1, Unit.OZ);
        var threeTsp = new Quantity(2, Unit.TBSP);
        assertEquals(oneOz, threeTsp);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        var twoInches = new Quantity(2, Unit.INCH);
        var fourInches = new Quantity(4, Unit.INCH);
        assertEquals(fourInches, twoInches.add(twoInches));
    }

    @Test
    public void twoTablespoonsPlusOneOzShouldEqualTwelveTsp() {
        var twoTbsp = new Quantity(2, Unit.TBSP);
        var oneOz = new Quantity(1, Unit.OZ);
        var twelveTsp = new Quantity(12, Unit.TSP);
        assertEquals(twelveTsp, twoTbsp.add(oneOz));
    }

    @Test
    public void oneHundredCelsiusShouldEqual212F() {
        var oneHundredCelsius = new Quantity(100, Unit.CELSIUS);
        var twoHundredTwelveFahrenheit = new Quantity(212, Unit.FAHRENHEIT);
        assertEquals(oneHundredCelsius, twoHundredTwelveFahrenheit);
    }

    @Test
    public void zeroCelsiusShouldEqual32F() {
        var zeroCelsius = new Quantity(0, Unit.CELSIUS);
        var thirtyTwoFahrenheit = new Quantity(32, Unit.FAHRENHEIT);
        assertEquals(zeroCelsius, thirtyTwoFahrenheit);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToAddIncomparableUnits() {
        var twoTbsp = new Quantity(2, Unit.TBSP);
        var oneInch = new Quantity(1, Unit.INCH);
        try {
            assertEquals(new Quantity(1, Unit.OZ), twoTbsp.add(oneInch));
        } catch (Exception e) {
            throw new RuntimeException("I couldn't do anything about this!", e);
        }
    }
}
