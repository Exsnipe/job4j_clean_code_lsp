package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;

import java.util.Optional;
import java.util.Scanner;

public class ExecuteAction implements UserAction {
    private Scanner scanner;

    public ExecuteAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getName() {
        return "==Execute action==";
    }

    @Override
    public boolean execute(Menu menu) {
        System.out.println(getName());
        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();
        Optional<Menu.MenuItemInfo> menuItemInfo = menu.select(itemName);
        menuItemInfo.ifPresent(itemInfo -> itemInfo.getActionDelegate().delegate());
        return true;
    }
}
