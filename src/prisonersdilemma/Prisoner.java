package prisonersdilemma;

import sim_station.MobileAgent;

public class Prisoner extends MobileAgent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy strategy;

    public Prisoner(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean cooperate() {
        return strategy.cooperate(partnerCheated);
    }

    public void updateFitness(int amount) {
        fitness += amount;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public void update() {
        Prisoner neighbor = (Prisoner) world.getNeighbor(this, 10);
        if (neighbor != null) {
            boolean myChoice = cooperate();
            boolean theirChoice = neighbor.cooperate();

            if (myChoice && theirChoice) {
                updateFitness(3);
                neighbor.updateFitness(3);
            } else if (!myChoice && theirChoice) {
                updateFitness(5);
                neighbor.updateFitness(0);
            } else if (myChoice && !theirChoice) {
                updateFitness(0);
                neighbor.updateFitness(5);
            } else {
                updateFitness(1);
                neighbor.updateFitness(1);
            }

            partnerCheated = !theirChoice;
        }
    }
}