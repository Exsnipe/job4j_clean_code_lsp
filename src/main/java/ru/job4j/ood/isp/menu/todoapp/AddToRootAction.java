package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;

import java.util.Scanner;

public class AddToRootAction implements UserAction {
    private Scanner scanner;

    public AddToRootAction(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getName() {
        return "==Add item to Root==";
    }

    @Override
    public boolean execute(Menu menu) {
        System.out.println(getName());
        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();
        boolean result = menu.add(Menu.ROOT, itemName, () -> System.out.println("Some action"));
        System.out.println("result is " + result);
        return true;
    }
}
