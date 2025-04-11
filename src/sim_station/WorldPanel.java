package sim_station;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class WorldPanel extends AppPanel {
    protected JPanel threadPanel = new JPanel();

    public WorldPanel(AppFactory factory) {
        super(factory);
        frame.setSize(1000, 550);

        threadPanel.setLayout(new GridLayout(1, 5));
        
        String[] buttonLabels = {"Start", "Pause", "Resume", "Stop", "Stats"};
        for (String label : buttonLabels) {
            JPanel p = new JPanel();
            JButton button = new JButton(label);
            button.addActionListener(this);
            p.add(button);
            threadPanel.add(p);
        }
        
        controlPanel.setLayout(new BorderLayout());
        
        JPanel p = new JPanel();
        p.add(threadPanel);
        
        controlPanel.add(p, BorderLayout.NORTH);
        ((World) model).populate();
    }

    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);

        var world = (World) newModel;
        for (Agent a : world.agents) {
            a.start();
            a.pause();
        }
    }
}
