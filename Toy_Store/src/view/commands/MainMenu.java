package view.commands;

import view.view.Console;

import java.util.ArrayList;

public class MainMenu extends Menu{

    public MainMenu(Console console) {
        commandsList = new ArrayList<>();
        commandsList.add(new ChoseAdmin(console));
        commandsList.add(new ChosePlayer(console));
        commandsList.add(new Finish(console));
    }

    public String menu() {
        StringBuilder strbuilder = new StringBuilder();
        for (int i = 0; i < commandsList.size(); i++) {
            strbuilder.append(i + 1);
            strbuilder.append(". ");
            strbuilder.append(commandsList.get(i).getCommandDescription());
            strbuilder.append("\n");
        }
        return strbuilder.toString();
    }

    @Override
    public void execute(int act) {
        Command command = commandsList.get(act - 1);
        command.execute();
    }
}
