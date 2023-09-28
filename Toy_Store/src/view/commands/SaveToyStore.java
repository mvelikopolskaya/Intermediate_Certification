package view.commands;

import view.view.Console;

public class SaveToyStore extends Command{
    public SaveToyStore(Console console) {
        super("Сохранить список игрушек", console);
    }

    @Override
    public void execute() {
        getConsole().saveToyStore();
    }
}
