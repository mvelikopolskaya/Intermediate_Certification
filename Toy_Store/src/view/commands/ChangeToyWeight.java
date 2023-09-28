package view.commands;

import view.view.Console;

public class ChangeToyWeight extends Command{
    public ChangeToyWeight(Console console) {
        super("Изменить вес игрушки", console);
    }

    @Override
    public void execute() {
        getConsole().changeToyWeight();
    }
}
