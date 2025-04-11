import sim_station.WorldFactory;
import sim_station.WorldPanel;
import sim_station.randomWalk.RandomWalkFactory;

public class Main {
    public static void main(String[] args) {
        WorldPanel app = new WorldPanel(new RandomWalkFactory());
        app.display();
    }
}