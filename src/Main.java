import sim_station.WorldFactory;
import sim_station.WorldPanel;

public class Main {
    public static void main(String[] args) {
        WorldPanel app = new WorldPanel(new WorldFactory());
        app.display();
    }
}