package greed;

import mvc.Model;
import mvc.View;
import sim_station.Agent;
import sim_station.WorldView;
import java.awt.*;
import java.util.ArrayList;

public class GreedView extends WorldView {
    private Meadow meadow;

    public GreedView(Model model) {
        super(model);
        this.meadow = (Meadow) model;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Patch> patches = meadow.getPatches();
        for (Patch patch : patches) {
            int patchSize = 10;
            g.setColor(patch.getColor());
            g.fillRect(patch.getX(), patch.getY(), patchSize, patchSize);
        }

        for (Agent a : meadow.getAgents()) {
            if (a instanceof Cow) {
                Cow cow = (Cow) a;
                g.setColor(cow.getColor());
                int size = 6;
                g.fillOval(a.getX() - size/2, a.getY() - size/2, size, size);
            }
        }

        g.setColor(Color.BLUE);
        g.drawRect(0, 0, meadow.WORLD_SIZE, meadow.WORLD_SIZE);
    }
}