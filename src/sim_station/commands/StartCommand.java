package sim_station.commands;

import mvc.*;
import sim_station.World;

public class StartCommand extends Command {
    private final World world;

    public StartCommand(Model model) {
        super(model);
        this.world = (World) model;
    }

    @Override
    public void execute() throws Exception {
        world.startAgents();
    }
} 