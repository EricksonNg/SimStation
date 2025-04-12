package plague;

import mvc.Utilities;
import sim_station.Heading;
import sim_station.MobileAgent;

public class Infected extends MobileAgent {
    @Override
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
    }
}
