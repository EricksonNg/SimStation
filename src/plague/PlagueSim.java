package plague;

import sim_station.World;

public class PlagueSim extends World {
    public static int INITIAL_INFECTED = 25;
    public static int VIRULENCE = 50;
    public static int POPULATION_SIZE = 50;
    public static int RECOVERY_TIME = 300;
    private boolean fatal = false;

    public PlagueSim() {
        super();
    }

    public PlagueSim(int initialInfected, int initialVirulence, int populationSize, int recoveryTime) {
        INITIAL_INFECTED = initialInfected;
        VIRULENCE = initialVirulence;
        POPULATION_SIZE = populationSize;
        RECOVERY_TIME = recoveryTime;
    }

    public void setVirulence(int value) {
        VIRULENCE = value;
    }

    public void setInitialInfected(int value) {
        INITIAL_INFECTED = value;
    }

    public void setPopulationSize(int value) {
        POPULATION_SIZE = value;
    }

    public void setRecoveryTime(int value) {
        RECOVERY_TIME = value;
    }

    public void setFatal(boolean value) {
        fatal = value;
    }

    public boolean isFatal() {
        return fatal;
    }

    @Override
    public void populate() {
        agents.clear();

        for (int i = 0; i < POPULATION_SIZE; i++) {
            if (i < INITIAL_INFECTED) {
                Infected host = new Infected(true);
                addAgent(host);
            } else {
                Infected host = new Infected(false);
                addAgent(host);
            }
        }
    }

    @Override
    public String getStatus() {
        int infectedCount = 0;
        for (var agent : agents) {
            if (agent instanceof Infected && ((Infected)agent).isInfected()) {
                infectedCount++;
            }
        }

        double percentInfected = agents.size() > 0 ? 100.0 * infectedCount / agents.size() : 0;

        return String.format("#agents = %d\nclock = %d\n%% infected = %.1f", agents.size(), getClock(), percentInfected);
    }
}