package prisonersdilemma;

public class Cooperate implements Strategy {
    @Override
    public boolean cooperate(boolean partnerCheated) {
        return true;
    }
}