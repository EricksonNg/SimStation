package sim_station;

import mvc.*;

import java.util.ArrayList;

import static java.lang.Math.abs;

public abstract class World extends Model {
    private static final long serialVersionUID = 1L;
    public static int WORLD_SIZE = 500;
    private int clock = 0;
    private int alive = 0;
    private ObserverAgent observer = new ObserverAgent(this);
    protected ArrayList<Agent> agents = new ArrayList<Agent>(100);

    public int getClock() {
        return clock;
    }

    public void addAgent(Agent a) {
        a.setWorld(this);
        agents.add(a);
        a.setPosition(Utilities.rng.nextInt(WORLD_SIZE), Utilities.rng.nextInt(WORLD_SIZE));
        changed();
    }

    public void startAgents() {
        for (Agent a : agents) {
            a.start();
        }
        observer.start();
    }

    public void stopAgents() {
        for (Agent a : agents) {
            a.stop();
        }
        observer.stop();
        agents.clear();
        clock = 0;
        alive = 0;
    }

    public void pauseAgents() {
        for (Agent a : agents) {
            a.pause();
        }
        observer.pause();
    }

    public void resumeAgents() {
        for (Agent a : agents) {
            a.resume();
        }
        observer.resume();
    }

    public abstract void populate();

    public String getStatus() {
        return String.format("#agents = %d\n#living = %d\n#clock = %d", agents.size(), alive, clock);
    }

    public void updateStatistics() {
        clock++;
        alive = 0;
        for (Agent a : agents) {
            if (!a.stopped) alive++;
        }
    }

    public Agent getNeighbor(Agent caller, int radius) {
        for (Agent a : agents) {
            if (a == caller) {
                continue;
            }
            if (abs(a.getX() - caller.getX()) < radius && abs(a.getY() - caller.getY()) < radius) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }
}