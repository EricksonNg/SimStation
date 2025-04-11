package sim_station;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class WorldPanel extends AppPanel {
    public WorldPanel(AppFactory factory) {
        super(factory);
        createButtons(this);
    }

    protected void createButtons(ActionListener listener) {
        String[] commands = factory.getEditCommands();
        for (String command : commands) {
            JButton b = new JButton(command);
            b.addActionListener(listener);
            controlPanel.add(b);
        }
    }

    public void setModel(Model model) {
        super.setModel(model);
        World w = (World) model;
        Iterator<Agent> it = w.getAgents().iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start();
        }
    }

}
