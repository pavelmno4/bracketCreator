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
                new Participant(2, "Вася", "Петров", 2011, 44, "Мотылёк"),
                new Participant(3, "Игорь", "Васильев", 2012, 41, "Бабочки"),
                new Participant(4, "Лёша", "Сидоров", 2012, 46, "Лягушки"),
                new Participant(5, "Игнат", "Теренко", 2012, 29, "Травушка")
        );

        int yearNow = LocalDate.now().getYear();

        Set<Category> categories = new HashSet<>();

        for (AgeCategory ac : AgeCategory.values()) {
            for (int weight : ac.getWeights()) {
                List<Participant> prts =
                        participants.stream()
                                .filter(p -> ((yearNow - p.getBirthYear()) >= ac.getLowAgeLimit() &
                                        (yearNow - p.getBirthYear()) <= ac.getHighAgeLimit()))
                                .filter(p -> weightCategory(p.getWeight(), ac.getWeights()) == weight)
                                .collect(Collectors.toList());

                categories.add(new Category(ac, weight, prts));
            }
        }

        categories.stream()
                .filter(c -> !c.getParticipants().isEmpty())
                .forEach(System.out::println);

    }

    public static int weightCategory(int weight, List<Integer> weightCategories) {
        List<Integer> cts =
                weightCategories.stream()
                        .filter(c -> c >= weight)
                        .collect(Collectors.toList());
        return cts.get(0);
    }
}
