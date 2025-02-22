package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;

public class QuitAction implements UserAction {
    @Override
    public String getName() {
        return "==Quit menu==";
    }

    @Override
    public boolean execute(Menu menu) {
        System.out.println("Quit");
        return false;
    }
}
