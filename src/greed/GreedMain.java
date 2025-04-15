package greed;

import sim_station.WorldPanel;

public class GreedMain {
    public static void main(String[] args) {
        WorldPanel app = new GreedPanel(new GreedFactory());
        app.display();
    }
}