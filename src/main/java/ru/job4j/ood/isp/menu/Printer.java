package ru.job4j.ood.isp.menu;

import java.util.Arrays;

public class Printer implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        menu.forEach(el -> System.out.println(returnTubs(el) + el.getNumber() + el.getName()));

    }

    public String returnTubs(Menu.MenuItemInfo menuItemInfo) {
        long tabsAmount = Arrays.stream(Arrays.stream(menuItemInfo.getNumber()
                .split(" ")).findFirst().get().split("\\.")).count();
        return "\t".repeat((int) tabsAmount - 1);
    }
}
