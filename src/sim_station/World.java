package sim_station;

import mvc.Model;

import java.util.ArrayList;

public abstract class World extends Model {
    private static final long serialVersionUID = 1L; // Ensures compatibility across versions
    public static int WORLD_SIZE = 500;
    private int clock = 0;
    private int alive = 0;
    private ArrayList<Agent> agents = new ArrayList<Agent>(100);

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public void addAgent(Agent a) {
        agents.add(a);
    }

    public void startAgents() {
        for (Agent a : agents) {
            a.start();
        }
    }

    public void stopAgents() {
        for (Agent a : agents) {
            a.stop();
        }
    }

    public void pauseAgents() {
        for (Agent a : agents) {
            a.pause();
        }
    }

    public void resumeAgents() {
        for (Agent a : agents) {
            a.resume();
        }
    }

    public abstract void populate();

    public String getStatus() {
        return "";
    }

    public void updateStatistics() {
        clock++;
        alive++;
    }

    public Agent getNeighbor(Agent caller, int radius) {
        return new ObserverAgent(this);
    }



}
