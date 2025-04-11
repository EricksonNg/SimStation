package sim_station.commands;

import mvc.Model;
import mvc.Command;
import mvc.Utilities;
import sim_station.World;

public class StatsCommand extends Command {

    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        World world = (World) model;
        String status = world.getStatus();
        Utilities.inform(status);
    }
}