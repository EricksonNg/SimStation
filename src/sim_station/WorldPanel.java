package sim_station;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.event.ActionListener;

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

}
