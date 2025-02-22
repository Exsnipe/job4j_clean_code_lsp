package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.MenuPrinter;
import ru.job4j.ood.isp.menu.Printer;

public class PrintAction implements UserAction {
    @Override
    public String getName() {
        return "Printer menu";
    }

    @Override
    public boolean execute(Menu menu) {
        System.out.println(getName());
        MenuPrinter printer = new Printer();
        printer.print(menu);
        return true;
    }
}
