package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.todoapp.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TodoApp {

    public  void showMenu(List<UserAction> userActions) {
        System.out.println("==Select menu==");
        for (int i = 0; i < userActions.size(); i++) {
            System.out.println(i + 1 + ". " + userActions.get(i).getName());
        }
    }

    public static void main(String[] args) throws IOException {
        TodoApp todoApp = new TodoApp();
        Scanner scanner = new Scanner(System.in);
        List<UserAction> userActions = new ArrayList<>(Arrays.asList(new AddToRootAction(scanner),
                new AddToParent(scanner),
                new ExecuteAction(scanner),
                new PrintAction(),
                new QuitAction()));
        todoApp.showMenu(userActions);
        boolean run = true;
        Menu menu = new SimpleMenu();
        while (run) {
            todoApp.showMenu(userActions);
            int select = Integer.parseInt(scanner.nextLine());
            if (select < 1 || select > userActions.size()) {
                System.out.println("Type a correct menu number");
                continue;
            }
            run = userActions.get(select - 1).execute(menu);
        }
    }
}
