package view.commands;

import view.view.Console;

public abstract class Command implements ICommand{
    private String commandDescription;
    private Console console;

    public Command(String commandDescription, Console console) {
        this.commandDescription = commandDescription;
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }

    public String getCommandDescription(){
        return commandDescription;
    }
}
