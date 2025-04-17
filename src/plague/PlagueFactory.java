package plague;

import mvc.Model;
import sim_station.World;
import sim_station.WorldFactory;

public class PlagueFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PlagueSim();
    }

    public Model makeModel(int initialInfected, int initialVirulence, int populationSize, int recoveryTime) {
        return new PlagueSim(initialInfected, initialVirulence, populationSize, recoveryTime);
    }
}
