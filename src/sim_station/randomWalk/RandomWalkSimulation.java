package sim_station.randomWalk;


import mvc.*;
import sim_station.*;

class Drunk extends MobileAgent {

    public Drunk() {
        super();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
    }

}


public class RandomWalkSimulation extends World {

    public void populate() {
        for(int i = 0; i < 50; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new RandomWalkFactory());
        panel.display();
    }

}

