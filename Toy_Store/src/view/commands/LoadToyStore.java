package view.commands;

import view.view.Console;

public class LoadToyStore extends Command{
    public LoadToyStore(Console console) {
        super("Загрузить список игрушек", console);
    }

    @Override
    public void execute() {
        getConsole().loadToyStore();
    }
}
