package view.commands;

import view.view.Console;

public class ChoseAdmin extends Command{
    public ChoseAdmin(Console console) {
        super("Войти как администратор", console);
    }

    @Override
    public void execute() {
        getConsole().choseAdmin();
    }
}
