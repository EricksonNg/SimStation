package sim_station;

import mvc.*;
import plague.Infected;
import prisonersdilemma.Prisoner;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class WorldView extends View {
    private World world;

    public WorldView(Model model) {
        super(model);
        this.world = (World) model;
        setSize(World.WORLD_SIZE, World.WORLD_SIZE);
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackline);
        setBackground(Color.GRAY);
    }

    public void drawAgent(Agent a, Graphics g) {
        if (a instanceof Infected) {
            Infected host = (Infected) a;
            g.setColor(host.getColor());
        }
        else if (a instanceof Prisoner) {
            g.setColor(Color.ORANGE);
        }
        else {
            g.setColor(Color.RED);
        }

        int size = 10;
        g.fillOval(a.xc - size/2, a.yc - size/2, size, size);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);
        world = (World) newModel;
        world.populate();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, World.WORLD_SIZE, World.WORLD_SIZE);

        ArrayList<Agent> agents;
        synchronized (world.getAgents()) {
            agents = new ArrayList<>(world.getAgents());
        }

        for (Agent a : agents) {
            drawAgent(a, g);
        }
    }
}