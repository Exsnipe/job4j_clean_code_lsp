package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;

import java.util.Scanner;

public class AddToParent implements UserAction {
    private Scanner scanner;

    public AddToParent(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getName() {
        return "==Add item to parent menu==";
    }

    @Override
    public boolean execute(Menu menu) {
        System.out.println(getName());
        System.out.println("Enter parent name: ");
        String parentName = scanner.nextLine();
        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();
        boolean result = menu.add(parentName, itemName, () -> System.out.println("Some action"));
        System.out.println("result is " + result);
        return true;
    }
}
