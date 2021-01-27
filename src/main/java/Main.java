import entity.Category;
import entity.Participant;
import service.CategoryService;
import service.PartPrinter;
import structure.OlympicSystem;
import structure.System;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> prtInt = Arrays.asList(1, 2, 3, 4, 5, 6);

        System<Integer> integerOlympicSystem = new OlympicSystem<>(prtInt);
//        System.out.println(integerOlympicGrid.create());

        List<String> prtStr = List.of("Петя", "Гриша", "Аркаша", "Гена", "Вовка");

        System<String> stringOlympicSystem = new OlympicSystem<>(prtStr);
//        System.out.println(stringOlympicGrid.create());

        List<Participant> participants = List.of(
                new Participant(1, "Петя", "Иванов", 2012, 42, "Чижик"),
                new Participant(2, "Вася", "Петров", 2011, 44, "Мотылёк"),
                new Participant(3, "Игорь", "Васильев", 2012, 41, "Бабочки"),
                new Participant(4, "Лёша", "Сидоров", 2012, 46, "Лягушки"),
                new Participant(5, "Игнат", "Теренко", 2012, 29, "Травушка")
        );

        Set<Category> categories = new CategoryService().createCategories(participants);

        PartPrinter<Participant> partPrinter = new PartPrinter<>();
        categories.stream()
                .filter(c -> !c.getParticipants().isEmpty())
//                .forEach(java.lang.System.out::println)
        .forEach(c -> partPrinter.print(c.getParticipants()));
    }
}
