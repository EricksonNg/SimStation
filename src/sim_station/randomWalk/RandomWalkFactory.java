package sim_station.randomWalk;

import mvc.Model;
import sim_station.WorldFactory;

public class RandomWalkFactory extends WorldFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}
