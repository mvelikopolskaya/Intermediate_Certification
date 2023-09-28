package view.commands;

import view.view.Console;

public class ClearToyStore extends Command{
    public ClearToyStore(Console console) {
        super("Очистить список игрушек", console);
    }

    @Override
    public void execute() {
        getConsole().clearToyStore();
    }
}
