package prisonersdilemma;

public class TitForTat implements Strategy {
    @Override
    public boolean cooperate(boolean partnerCheated) {
        return !partnerCheated; // Cooperate unless the partner cheated last time
    }
}