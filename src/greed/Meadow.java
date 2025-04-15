package greed;

import mvc.Utilities;
import sim_station.Agent;
import sim_station.World;

import java.util.ArrayList;
import java.awt.*;

public class Meadow extends World {
    private Patch[][] patches;
    private int patchSize = 10;
    private int waitPenalty = 5;
    private int moveEnergy = 10;
    private int numCows = 50;
    private int growBackRate = 1;
    private int greediness = 25;
    private int gridDimension;

    public Meadow() {
        super();
        gridDimension = WORLD_SIZE / patchSize;
        patches = new Patch[gridDimension][gridDimension];
        initializePatches();
    }

    private void initializePatches() {
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                Patch patch = new Patch(i * patchSize, j * patchSize, patchSize, growBackRate);
                patch.setWorld(this);
                patches[i][j] = patch;
            }
        }
    }

    public Patch getPatch(int x, int y) {
        int gridX = x / patchSize;
        int gridY = y / patchSize;

        if (gridX >= 0 && gridX < gridDimension && gridY >= 0 && gridY < gridDimension) {
            return patches[gridX][gridY];
        }
        return null;
    }

    public int getWaitPenalty() {
        return waitPenalty;
    }

    public void setWaitPenalty(int waitPenalty) {
        this.waitPenalty = waitPenalty;
    }

    public int getMoveEnergy() {
        return moveEnergy;
    }

    public void setMoveEnergy(int moveEnergy) {
        this.moveEnergy = moveEnergy;
    }

    public int getGreediness() {
        return greediness;
    }

    public void setGreediness(int greediness) {
        this.greediness = greediness;

        for (Agent agent : agents) {
            if (agent instanceof Cow) {
                ((Cow) agent).setGreediness(greediness);
            }
        }
    }

    public void setGrowBackRate(int rate) {
        this.growBackRate = rate;

        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                patches[i][j].setGrowBackRate(rate);
            }
        }
    }

    public void setNumCows(int numCows) {
        this.numCows = numCows;
    }

    @Override
    public void populate() {
        stopAgents();
        agents.clear();

        for (int i = 0; i < numCows; i++) {
            Cow cow = new Cow(greediness);
            addAgent(cow);
        }
    }

    @Override
    public void updateStatistics() {
        super.updateStatistics();

        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                patches[i][j].update();
            }
        }
    }

    @Override
    public String getStatus() {
        int aliveCows = 0;
        int totalCows = 0;

        for (Agent agent : agents) {
            if (agent instanceof Cow) {
                totalCows++;
                if (!((Cow) agent).isDead()) {
                    aliveCows++;
                }
            }
        }

        double alivePercentage = totalCows > 0 ? 100.0 * aliveCows / totalCows : 0;

        return String.format("#cows = %d\n#alive = %d\n#clock = %d\n%% alive = %.1f",
                totalCows, aliveCows, getClock(), alivePercentage);
    }

    public ArrayList<Patch> getPatches() {
        ArrayList<Patch> patchList = new ArrayList<>();
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                patchList.add(patches[i][j]);
            }
        }
        return patchList;
    }
}