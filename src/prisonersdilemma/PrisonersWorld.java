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

    @Override
    public String getStatus() {
        int cooperateCount = 0;
        int cheatCount = 0;
        int randomCount = 0;
        int titForTatCount = 0;

        for (var agent : agents) {
            if (agent instanceof Prisoner) {
                Strategy strategy = ((Prisoner) agent).getStrategy();
                if (strategy instanceof Cooperate) cooperateCount++;
                else if (strategy instanceof Cheat) cheatCount++;
                else if (strategy instanceof Random) randomCount++;
                else if (strategy instanceof TitForTat) titForTatCount++;
            }
        }

        return String.format(
            "#agents = %d\nclock = %d\nCooperate = %d\nCheat = %d\nRandom = %d\nTitForTat = %d",
            agents.size(), getClock(), cooperateCount, cheatCount, randomCount, titForTatCount
        );
    }
}