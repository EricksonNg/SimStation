import sim_station.WorldPanel;
import prisonersdilemma.*;

public class PrisonerMain {
    public static void main(String[] args) {
        WorldPanel app = new PrisonersPanel(new PrisonersFactory());
        app.display();
    }
}