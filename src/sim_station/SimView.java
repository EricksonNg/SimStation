package sim_station;

import mvc.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SimView extends View {
    public SimView(Sim sim) {
        super(sim);
        setSize(Sim.WORLD_SIZE, Sim.WORLD_SIZE);
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
