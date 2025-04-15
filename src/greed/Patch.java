package greed;

import mvc.Utilities;
import sim_station.Agent;
import java.awt.Color;

public class Patch extends Agent {
    private int energy;
    private int growBackRate;
    private int patchSize;
    private static final int MAX_ENERGY = 100;

    public Patch(int x, int y, int patchSize, int growBackRate) {
        this.energy = MAX_ENERGY;
        this.growBackRate = growBackRate;
        this.patchSize = patchSize;
        setPosition(x, y);
    }

    public int getEnergy() {
        return energy;
    }

    public void setGrowBackRate(int rate) {
        this.growBackRate = rate;
    }

    public int eatMe(Cow cow, int amount) {
        int actualAmount = Math.min(amount, energy);
        energy -= actualAmount;
        return actualAmount;
    }

    public Color getColor() {
        int colorValue = 255 - (int)(energy * 2.0);
        if (colorValue < 0) colorValue = 0;
        if (colorValue > 255) colorValue = 255;
        return new Color(0, colorValue, 0);
    }

    @Override
    public void update() {
        energy = Math.min(MAX_ENERGY, energy + growBackRate);
        if (world != null) {
            world.changed();
        }
    }
}