package greed;

import mvc.Utilities;
import sim_station.Heading;
import sim_station.MobileAgent;
import java.awt.Color;

public class Cow extends MobileAgent {
    private int energy;
    private int greediness;
    private boolean dead;
    private static final int MAX_ENERGY = 100;

    public Cow(int greediness) {
        this.energy = MAX_ENERGY;
        this.greediness = greediness;
        this.dead = false;
    }

    public boolean isDead() {
        return dead;
    }

    public void setGreediness(int greediness) {
        this.greediness = greediness;
    }

    public Color getColor() {
        return dead ? Color.WHITE : Color.RED;
    }

    @Override
    public void update() {
        if (dead) return;

        energy -= 1;

        Meadow meadow = (Meadow) world;
        Patch currentPatch = meadow.getPatch(getX(), getY());

        if (currentPatch != null) {
            if (currentPatch.getEnergy() >= greediness) {
                int eaten = currentPatch.eatMe(this, greediness);
                energy = Math.min(MAX_ENERGY, energy + eaten);
            } else {
                if (energy >= meadow.getMoveEnergy()) {
                    heading = Heading.random();
                    move(10);
                    energy -= meadow.getMoveEnergy();
                } else {
                    energy -= meadow.getWaitPenalty();
                }
            }
        }

        if (energy <= 0) {
            dead = true;
            energy = 0;
        }

        world.changed();
    }
}