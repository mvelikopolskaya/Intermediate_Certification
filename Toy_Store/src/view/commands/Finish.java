package view.commands;

import view.view.Console;

public class Finish extends Command{
    public Finish(Console console) {
        super("Завершить работу", console);
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
