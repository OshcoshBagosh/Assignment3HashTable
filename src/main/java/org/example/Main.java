package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.add(new Player("Steve", 1));
        list.add(new Player("Josh", 2));
        list.add(new Player("Martin", 3));
        list.add(new Player("Levy", 4));

        System.out.println(list.find("Josh").getScore());

    }
}