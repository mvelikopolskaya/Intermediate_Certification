package view.commands;

import view.view.Console;
import java.util.ArrayList;

public class PlayerMenu extends Menu{

    public PlayerMenu(Console console) {
        commandsList = new ArrayList<>();
        commandsList.add(new Play(console));
        commandsList.add(new ReturnToMainMenu(console));
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

    public void execute(int act) {
        Command command = commandsList.get(act - 1);
        command.execute();
    }

    public int listSize() {
        return commandsList.size();
    }
}
