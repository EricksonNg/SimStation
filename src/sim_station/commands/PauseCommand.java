package sim_station.commands;

import mvc.*;
import sim_station.World;

public class PauseCommand extends Command{
    public PauseCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        ((World) model).pauseAgents();
    }
}
