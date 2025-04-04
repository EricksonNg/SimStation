package sim_station;

import mvc.AppFactory;
import mvc.Model;
import mvc.View;
import tools.Command;
import tools.Utilities;

public class SimFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Sim();
    }

    @Override
    public View makeView(Model model) {
        return new SimView((Sim) model);
    }

    @Override
    public String getTitle() {
        return "Sim Station";
    }

    @Override
    public String getAbout() {
        return "Team 10, 2025. All rights reserved.";
    }

    @Override
    public String getHelp() {
        return Utilities.buildMultilineString(
                "Start: ",
                "Pause: ",
                "Resume: ",
                "Stop: ",
                "Stats: "
        );
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Pause", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand (String name, Model model) throws Exception{
        // generate commands here, other return exception
        throw new Exception("No such command yet");
    }
}
