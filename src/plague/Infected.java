package plague;

import mvc.Utilities;
import sim_station.Agent;
import sim_station.Heading;
import sim_station.MobileAgent;

import java.awt.*;

public class Infected extends MobileAgent {
    private boolean infected;
    private int recoveryTimer = 0;
    private boolean resistant = false;

    public Infected() {
        this(false);
    }

    public Infected(boolean infected) {
        this.infected = infected;
        if (infected) {
            startRecoveryTimer();
        }

        if (Utilities.rng.nextInt(100) < PlagueSim.RESISTANCE) {
            resistant = true;
        }
    }

    public boolean isInfected() {
        return infected;
    }

    public boolean isResistant() {
        return resistant;
    }

    public Color getColor() {
        if (infected) {
            return Color.RED;
        } else if (resistant) {
            return Color.BLUE;
        } else {
            return Color.GREEN;
        }
    }

    private void startRecoveryTimer() {
        recoveryTimer = PlagueSim.RECOVERY_TIME;
    }

    private void tryToInfectNeighbor() {
        Infected neighbor = (Infected) world.getNeighbor(this, 10);
        if (neighbor != null) {

            if (neighbor.isInfected() && neighbor.isResistant()) {
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
                    infected = false;
                    resistant = true;

                    PlagueSim sim = (PlagueSim) world;
                    if (sim.isFatal() && Utilities.rng.nextInt(100) < 10) {
                        stop();
                    }
                }
            }
        }
    }
}