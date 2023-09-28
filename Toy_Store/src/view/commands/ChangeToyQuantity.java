package view.commands;

import view.view.Console;

public class ChangeToyQuantity extends Command{
    public ChangeToyQuantity(Console console) {
        super("Изменить количество игрушек", console);
    }

    @Override
    public void execute() {
        getConsole().changeToyQuantity();
    }
}
