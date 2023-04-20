package pl.javastart.task;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // tutaj możesz przeprowadzać manualne testy listy

        // lista powinna być parametryzowana (analogicznie jak java.util.ArrayList czy java.util.LinkedList)
        CustomList<String> customListOfStrings = new CustomList();
        customListOfStrings.add("Tomasz");
        customListOfStrings.add("Mateuszek");
        customListOfStrings.add("Przemek");
        customListOfStrings.add("Tadek");
        customListOfStrings.add("Wiola");
        customListOfStrings.add("Angelika");
        customListOfStrings.add(3, "Test");
        System.out.println(customListOfStrings);
    }
}
