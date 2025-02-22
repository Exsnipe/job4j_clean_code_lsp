package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Сходить в магазин",
                List.of("Купить продукты"), STUB_ACTION, "1."))
                .isEqualTo(menu.select("Сходить в магазин").get());
        assertThat(new Menu.MenuItemInfo(
                "Купить продукты",
                List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."))
                .isEqualTo(menu.select("Купить продукты").get());
        assertThat(new Menu.MenuItemInfo(
                "Покормить собаку", List.of(), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Покормить собаку").get());
    }

    @Test
    public void whenAddThenSelectTheSame2() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Morning tasks", STUB_ACTION);
        menu.add("Morning tasks", "Exercising", STUB_ACTION);
        menu.add("Morning tasks", "Reading", STUB_ACTION);
        menu.add(Menu.ROOT, "Working", STUB_ACTION);
        menu.add("Working", "Parachute packing", STUB_ACTION);
        menu.add("Parachute packing", "Packing Safire 2-129", STUB_ACTION);
        menu.add("Packing Safire 2-129", "Checking lines", STUB_ACTION);
        menu.add("Packing Safire 2-129", "Packing canopy", STUB_ACTION);
        menu.add("Parachute packing", "Parafoil-282", STUB_ACTION);
        menu.add("Working", "Developing documentation", STUB_ACTION);
        menu.add(Menu.ROOT, "Evening tasks", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Working", List.of("Parachute packing",
                "Developing documentation"), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Working").get());
        assertThat(new Menu.MenuItemInfo("Packing Safire 2-129", List.of("Checking lines",
                "Packing canopy"), STUB_ACTION, "2.1.1."))
                .isEqualTo(menu.select("Packing Safire 2-129").get());
        assertThat(new Menu.MenuItemInfo("Evening tasks", List.of(), STUB_ACTION, "3."))
                .isEqualTo(menu.select("Evening tasks").get());
    }

    @Test
    public void whenTestPrint() {
        String result = "";
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Fix car", STUB_ACTION);
        menu.add("Fix car", "Wash car", STUB_ACTION);
        menu.add("Wash car", "Wash wheels", STUB_ACTION);
        MenuPrinter printer = new Printer();
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            printer.print(menu);
             result = outputStream.toString().trim();
        } finally {
            System.setOut(originalOut);
        }
        String expected = "1.Fix car" + System.lineSeparator() + "\t" + "1.1.Wash car"
                + System.lineSeparator() + "\t".repeat(2) + "1.1.1.Wash wheels";
        assertThat(expected).isEqualTo(result);
    }
}