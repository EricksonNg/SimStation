package plague;

import mvc.Utilities;
import sim_station.Heading;
import sim_station.MobileAgent;

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

    private void startRecoveryTimer() {
        recoveryTimer = PlagueSim.RECOVERY_TIME;
    }

    private void tryToInfectNeighbor() {
        if (!infected) return;

        var neighbor = world.getNeighbor(this, 10);
        if (neighbor instanceof Infected) {
            Infected host = (Infected) neighbor;

            if (host.isInfected() || host.isResistant()) {
                return;
            }

            if (Utilities.rng.nextInt(100) < PlagueSim.VIRULENCE) {
                host.infected = true;
                host.startRecoveryTimer();
            }
        }
    }

    @Override
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

        tryToInfectNeighbor();

        if (infected && recoveryTimer > 0) {
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