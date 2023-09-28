package view.commands;

import view.view.Console;

public class ShowToyStore extends Command{
    public ShowToyStore(Console console) {
        super("Показать список игрушек", console);
    }

    @Override
    public void execute() {
        getConsole().showToyStore();
    }
}
