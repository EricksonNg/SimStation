package prisonersdilemma;

import mvc.Model;
import sim_station.WorldFactory;

public class PrisonersFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PrisonersWorld();
    }

    @Override
    public String getTitle() {
        return "Prisoner's Dilemma";
    }
}