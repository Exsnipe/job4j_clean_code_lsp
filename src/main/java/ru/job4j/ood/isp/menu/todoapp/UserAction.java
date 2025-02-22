package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;

public interface UserAction {

    String getName();

    boolean execute(Menu menu);
}
