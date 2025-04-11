package sim_station;

import mvc.*;

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

    public void drawAgent(Graphics g, Agent a) {
        g.setColor(Color.RED);
        g.fillOval(a.xc, a.yc, 10, 10);
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
            drawAgent(g, a);
        }
    }
}
