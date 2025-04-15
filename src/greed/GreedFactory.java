package greed;

import mvc.Model;
import mvc.View;
import sim_station.WorldFactory;

public class GreedFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new Meadow();
    }

    @Override
    public View makeView(Model model) {
        return new GreedView(model);
    }

    @Override
    public String getTitle() {
        return "Greed Simulation";
    }

    @Override
    public String about() {
        return "Greed Simulation\nTeam 10, 2025. All rights reserved.";
    }
}