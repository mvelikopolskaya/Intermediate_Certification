package view.commands;

import view.view.Console;

public class AddToy extends Command{
    public AddToy(Console console) {
        super("Добавить игрушку", console);
    }

    @Override
    public void execute() {
        getConsole().addToyToTheStore();
    }
}
