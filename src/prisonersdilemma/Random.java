package prisonersdilemma;

import mvc.Utilities;

public class Random implements Strategy {
    @Override
    public boolean cooperate(boolean partnerCheated) {
        return Utilities.rng.nextBoolean();
    }
}