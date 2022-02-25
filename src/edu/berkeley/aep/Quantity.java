package edu.berkeley.aep;

// Understands a measurement in a given unit
public class Quantity {
    private final int amount;
    private final Unit unit;

    public Quantity(int amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Quantity)) return false;
        Quantity otherQuantity = (Quantity) other;
        return otherQuantity.convert(this.unit) == amount;
    }

    private int convert(Unit unit) {
        return this.unit.convertTo(unit, amount);
    }

    @Override
    public String toString() {
        return amount + " " + unit;
    }

    public Quantity add(Quantity other) {
        if (!unit.isComparableTo(other.unit))
            throw new RuntimeException("Cannot compare a " + unit + " to a " + other.unit);
        var otherAmount = other.unit.convertTo(this.unit, other.amount);
        return new Quantity(amount + otherAmount, unit);
    }
}
