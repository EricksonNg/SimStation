import plague.PlaguePanel;
import sim_station.WorldPanel;
import plague.PlagueFactory;

public class PlagueMain {
    public static void main(String[] args) {
        WorldPanel app = new PlaguePanel(new PlagueFactory());
        app.display();
    }
}