package view.commands;

import view.view.Console;

public class ReturnToMainMenu extends Command{
    public ReturnToMainMenu(Console console) {
        super("Вернуться в главное меню", console);
    }

    @Override
    public void execute() {
        getConsole().returnToMainMenu();
    }
}
