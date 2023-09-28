package view.commands;

import view.view.Console;

import java.util.ArrayList;
import java.util.List;

public class StoreMenu extends Menu{

    public StoreMenu(Console console) {
        commandsList = new ArrayList<>();
        commandsList.add(new AddToy(console));
        commandsList.add(new ChangeToyName(console));
        commandsList.add(new ChangeToyQuantity(console));
        commandsList.add(new ChangeToyWeight(console));
        commandsList.add(new ClearToyStore(console));
        commandsList.add(new ShowToyStore(console));
        commandsList.add(new SaveToyStore(console));
        commandsList.add(new LoadToyStore(console));
        commandsList.add(new Play(console));
        commandsList.add(new GetToyFromQueue(console));
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
}
