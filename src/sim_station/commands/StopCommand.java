package sim_station.commands;

import mvc.*;
import sim_station.World;

public class StopCommand extends Command{
    public StopCommand(Model model) {
        super(model);
    }
    
    @Override
    public void execute() {
        ((World) model).stopAgents();
    }
}
