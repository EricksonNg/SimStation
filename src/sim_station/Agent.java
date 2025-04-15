package sim_station;

import java.awt.*;
import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility across versions
    int xc;
    int yc;
    boolean paused  = false;
    boolean stopped = false;
    String agentName;
    Thread myThread;
    protected World world;

    public void setWorld(World newWorld) {
        world = newWorld;
    }

    public void setPosition(int x, int y) {
        this.xc = x;
        this.yc = y;
    }

    public int getX() {
        return xc;
    }

    public int getY() {
        return yc;
    }

    public void start() {
        if (stopped) {
            stopped = false;
        }
        
        if (myThread == null) {
            myThread = new Thread(this);
            myThread.start();
        }
    }

    public void stop() {
        if (myThread != null) {
            stopped = true;
            paused = true;
            myThread.interrupt();
            myThread = null;
        }
    }

    public void pause() {
        if (myThread != null) {
            paused = true;
        }
    }

    public void resume() {
        if (paused == true) {
            paused = false;
            synchronized (myThread) {
                myThread.notify();
            }
        }
    }

    public abstract void update();

    public void run() {
        while (!stopped) {
            if (!paused) {
                update();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
