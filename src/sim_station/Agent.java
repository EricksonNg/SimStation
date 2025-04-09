package sim_station;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility across versions
    int xc;
    int yc;
    boolean paused  = false;
    boolean stopped = false;
    String agentName;
    Thread myThread;

    public void start() {

    }

    public void stop() {

    }

    public void pause() {

    }

    public void resume() {

    }

    public abstract void update();

    public void run() {
        update();
    }
}
