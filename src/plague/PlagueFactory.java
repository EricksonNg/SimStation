package plague;

import mvc.Model;
import sim_station.WorldFactory;

public class PlagueFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PlagueSim();
    }
}
