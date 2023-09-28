package view.commands;


import view.view.Console;

public class GetToyFromQueue extends Command{
    public GetToyFromQueue(Console console) {
        super("Удалить игрушку из списка", console);
    }

    @Override
    public void execute() {
        getConsole().getToyFromQueue();
    }
}
