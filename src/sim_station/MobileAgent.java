package sim_station;


public abstract class MobileAgent extends Agent {
    public Heading heading;

    public void move(int steps) {
        if (heading == Heading.NORTH) {
            this.yc = Math.floorMod(this.yc - steps, World.WORLD_SIZE + 1);
        }
        else if (heading == Heading.SOUTH) {
            this.yc = Math.floorMod(this.yc + steps, World.WORLD_SIZE + 1);
        }
        else if (heading == Heading.EAST) {
            this.xc = Math.floorMod(this.xc + steps, World.WORLD_SIZE + 1);
        }
        else if (heading == Heading.WEST) {
            this.xc = Math.floorMod(this.xc - steps, World.WORLD_SIZE + 1);
        }
        world.changed();
    }

    public void turn(Heading direction) {
        heading = direction;
    }
}
