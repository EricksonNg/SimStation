import sim_station.SimFactory;
import sim_station.SimPanel;

public class Main {
    public static void main(String[] args) {
        SimPanel app = new SimPanel(new SimFactory());
        app.display();
    }
}