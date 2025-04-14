package prisonersdilemma;

import sim_station.World;

public class PrisonersWorld extends World {
    @Override
    public void populate() {
        for (int i = 0; i < 10; i++) { // 1/4 agents each category
            addAgent(new Prisoner(new Cooperate()));
            addAgent(new Prisoner(new Cheat()));
            addAgent(new Prisoner(new Random()));
            addAgent(new Prisoner(new TitForTat()));
        }
    }
}