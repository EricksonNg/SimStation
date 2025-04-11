package sim_station.commands;

import mvc.*;
import sim_station.World;

public class ResumeCommand extends Command{
    public ResumeCommand(Model model) {
        super(model);
    }
    
    @Override
    public void execute() {
        ((World) model).resumeAgents();
    }
}
