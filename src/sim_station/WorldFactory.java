package sim_station;

import mvc.*;
import sim_station.commands.*;

public class WorldFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new World() {
            @Override
            public void populate() {
            }
        };
    }

    @Override
    public View makeView(Model model) {
        return new WorldView(model);
    }

    @Override
    public String getTitle() {
        return "Sim Station";
    }

    @Override
    public String about() {
        return "Team 10, 2025. All rights reserved.";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Resume", "Pause", "Stop", "Stats", "Start"};
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Pause", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand (Model model, String cmmd) throws Exception{
        switch (cmmd) {
            case "Start":
                return new StartCommand(model);
            case "Pause":
                return new PauseCommand(model);
            case "Resume":
                return new ResumeCommand(model);
            case "Stop":
                return new StopCommand(model);
            case "Stats":
                 return new StatsCommand(model);
            default:
                throw new Exception("No such command yet");
        }
    }
}
