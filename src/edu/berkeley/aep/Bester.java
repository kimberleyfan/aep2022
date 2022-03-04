package edu.berkeley.aep;

public class Bester {
    private final ScaledQuantity[] quantities;

    public Bester(ScaledQuantity... quantities) {
        this.quantities = quantities;
    }

    public ScaledQuantity best() {
        var champion = quantities[0];
        for (var challenger : quantities) {
            if (challenger.betterThan(champion)) {
                champion = challenger;
            }
        }
        return champion;
    }
}
