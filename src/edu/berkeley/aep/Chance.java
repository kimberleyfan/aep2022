package edu.berkeley.aep;

// Understands the likelihood of something happening
public class Chance implements Bestable {
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        return Double.compare(((Chance) other).probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }

    public Chance not() {
        return new Chance(1 - probability);
    }

    public Chance and(Chance dieRoll) {
        return new Chance(probability * dieRoll.probability);
    }

    public Chance or(Chance otherProbability) {
        // calculate or using DeMorgan's Law
        return this.not().and(otherProbability.not()).not();
    }

    @Override
    public boolean betterThan(Bestable other) {
        Chance otherProbability = (Chance) other;
        return probability > otherProbability.probability;
    }
}
