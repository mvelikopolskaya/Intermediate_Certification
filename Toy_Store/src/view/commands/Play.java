package view.commands;

import view.view.Console;

public class Play extends Command{
    public Play(Console console) {
        super("Играть", console);
    }

    @Override
    public void execute() {
        getConsole().play();
    }
}
