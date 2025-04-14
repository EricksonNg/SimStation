package prisonersdilemma;

public class Cheat implements Strategy {
    @Override
    public boolean cooperate(boolean partnerCheated) {
        return false;
    }
}