package sim_station;

public class ObserverAgent extends Agent {
    private World world;

    public ObserverAgent(World w) {
        world = w;
    }

    @Override
    public void update() {
        world.updateStatistics();
    }
}
