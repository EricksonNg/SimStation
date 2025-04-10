package mvc;

public interface AppFactory {
    public Model makeModel();

    public View makeView(Model m);

    public String[] getEditCommands();

    public Command makeEditCommand(Model m, String t) throws Exception;

    public String getTitle();

    public String[] getHelp();

    public String about();
}
