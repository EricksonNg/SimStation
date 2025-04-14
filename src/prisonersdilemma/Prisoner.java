package prisonersdilemma;
import mvc.Utilities;
import sim_station.Heading;
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

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public Strategy getStrategy() {
        return strategy;
    }

@Override
public void update() {

    Prisoner neighbor = (Prisoner) world.getNeighbor(this, 10);

    if (neighbor != null) {


        boolean myChoice = cooperate();
        boolean theirChoice = neighbor.cooperate();

        int myFitnessChange = 0;
        int theirFitnessChange = 0;

        if (myChoice && theirChoice) {
            myFitnessChange = 3;
            theirFitnessChange = 3;
        } else if (!myChoice && theirChoice) {
            myFitnessChange = 5;
            theirFitnessChange = 0;
        } else if (myChoice && !theirChoice) {
            myFitnessChange = 0;
            theirFitnessChange = 5;
        } else {
            myFitnessChange = 1;
            theirFitnessChange = 1;
        }

        updateFitness(myFitnessChange);
        neighbor.updateFitness(theirFitnessChange);

        if (this.getFitness() <= 0) {
            world.removeAgent(this); // Remove this prisoner if it loses
        } else if (neighbor.getFitness() <= 0) {
            world.removeAgent(neighbor);
        }

        this.setPosition(neighbor.getX(), neighbor.getY());
    } else {
        // If no neighbor is found, move randomly
        heading = Heading.random();
        move(Utilities.rng.nextInt(10) + 1);
    }
}
}