package sim_station;


public abstract class MobileAgent extends Agent {
    public Heading heading;
    protected int xc, yc;

    public int getX() {
        return xc;
    }
    
    public int getY() {
        return yc;
    }   

    public void setX(int x) {
        this.xc = x;
    }

    public void setY(int y) {
        this.yc = y;
    }

    public void move(int steps) {
        switch (heading) {
            case NORTH : this.yc = Math.floorMod(this.yc + steps, World.WORLD_SIZE + 1);
            case SOUTH : this.yc = Math.floorMod(this.yc - steps, World.WORLD_SIZE + 1);
            case EAST : this.xc = Math.floorMod(this.xc + steps, World.WORLD_SIZE + 1);
            case WEST : this.xc = Math.floorMod(this.xc - steps, World.WORLD_SIZE + 1);
        }
        world.changed();
    }

    public void turn(Heading direction) {
        heading = direction;
    }
}
