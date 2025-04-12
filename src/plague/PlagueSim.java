package plague;

import sim_station.World;

public class PlagueSim extends World {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    @Override
    public void populate() {
        for (int i = 0; i < 100; i++) {
            addAgent(new Infected());
        }
    }
}
