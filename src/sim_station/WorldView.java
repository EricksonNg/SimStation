package sim_station;

import mvc.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WorldView extends View {
    public WorldView(World world) {
        super(world);
        setSize(World.WORLD_SIZE, World.WORLD_SIZE);
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackline);
        setBackground(Color.GRAY);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
