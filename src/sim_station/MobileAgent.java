package sim_station;

public abstract class MobileAgent extends Agent {
    Heading heading;

    public void move(int steps) {

    }

    public void turn(Heading direction) {
        heading = direction;
    }
}
