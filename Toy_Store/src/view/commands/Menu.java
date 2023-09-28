package view.commands;


import view.view.Console;

import java.util.List;

public abstract class Menu {
    protected List<Command> commandsList;


    public String menu() {
        return null;
    }

    public abstract void execute(int act);
}
