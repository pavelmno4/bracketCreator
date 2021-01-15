import entity.AgeCategory;
import entity.Participant;
import structure.Category;
import structure.Grid;
import structure.OlympicGrid;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> prtInt = Arrays.asList(1, 2, 3, 4, 5, 6);

        Grid<Integer> integerOlympicGrid = new OlympicGrid<>(prtInt);
//        System.out.println(integerOlympicGrid.create());

        List<String> prtStr = List.of("Петя", "Гриша", "Аркаша", "Гена", "Вовка");

        Grid<String> stringOlympicGrid = new OlympicGrid<>(prtStr);
//        System.out.println(stringOlympicGrid.create());

        List<Participant> participants = List.of(
                new Participant(1, "Петя", "Иванов", 2012, 42, "Чижик"),
                new Participant(2, "Вася", "Петров", 2014, 44, "Мотылёк"),
                new Participant(3, "Игорь", "Васильев", 2012, 41, "Бабочки"),
                new Participant(4, "Лёша", "Сидоров", 2012, 46, "Лягушки")
        );

        int YEAR_NOW = LocalDate.now().getYear();

        Set<Category> categories = new HashSet<>();

        for (AgeCategory ac : AgeCategory.values()) {
            for (int weight : ac.getWeights()) {
                List<Participant> prts =
                        participants.stream()
                                .filter(p -> ((YEAR_NOW - p.getBirthYear()) >= ac.getLowAgeLimit() &
                                        (YEAR_NOW - p.getBirthYear()) <= ac.getHighAgeLimit()))
                                .filter(p -> p.getWeight() <= 45)
                                .collect(Collectors.toList());

                categories.add(new Category(ac, 45, prts));
            }
        }

        System.out.println(categories);
    }
}
