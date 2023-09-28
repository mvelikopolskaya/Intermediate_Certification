package view.commands;

import view.view.Console;

public class ChosePlayer extends Command{
    public ChosePlayer(Console console) {
        super("Войти как игрок", console);
    }

    @Override
    public void execute() {
        getConsole().chosePlayer();
    }
}
