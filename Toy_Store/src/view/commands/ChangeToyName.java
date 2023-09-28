package view.commands;

import view.view.Console;

public class ChangeToyName extends Command{
    public ChangeToyName(Console console) {
        super("Изменить имя игрушки", console);
    }

    @Override
    public void execute() {
        getConsole().changeToyName();
    }
}
