package sim_station;

import mvc.*;
import plague.Infected;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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
        } else {
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, World.WORLD_SIZE, World.WORLD_SIZE);
        for (Agent a : world.getAgents()) {
            drawAgent(a, g);
        }
    }
}