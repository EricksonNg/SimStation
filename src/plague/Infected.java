package plague;

import mvc.Utilities;
import sim_station.Agent;
import sim_station.Heading;
import sim_station.MobileAgent;

import java.awt.*;

public class Infected extends MobileAgent {
    private boolean infected;
    private int recoveryTimer = 0;

    public Infected() {
        this(false);
    }

    public Infected(boolean infected) {
        this.infected = infected;
        if (infected) {
            startRecoveryTimer();
        }
    }

    public boolean isInfected() {
        return infected;
    }

    public Color getColor() {
        if (infected) {
            return Color.RED;
        }
        else {
            return Color.GREEN;
        }
    }

    private void startRecoveryTimer() {
        recoveryTimer = PlagueSim.RECOVERY_TIME;
    }

    private void tryToInfectNeighbor() {
        Infected neighbor = (Infected) world.getNeighbor(this, 10);
        if (neighbor != null) {

            if (neighbor.isInfected()) {
                return;
            }

            if (Utilities.rng.nextInt(100) < PlagueSim.VIRULENCE) {
                neighbor.infected = true;
                neighbor.startRecoveryTimer();
            }
        }
    }

    @Override
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

        if (infected) {
            tryToInfectNeighbor();
            if (recoveryTimer > 0) {
                recoveryTimer--;
                if (recoveryTimer <= 0) {
                    PlagueSim sim = (PlagueSim) world;
                    if (sim.isFatal()) {
                        stop();
                    }
                    else {
                        infected = false;
                    }
                }
            }
        }
    }
}