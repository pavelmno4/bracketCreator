import entity.Category;
import entity.Participant;
import service.CategoryService;
import service.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> prtInt = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Participant> participants = List.of(
                new Participant(1, "Петя", "Иванов", 2012, 42, "Чижик"),
                new Participant(2, "Вася", "Петров", 2012, 41, "Мотылёк"),
                new Participant(3, "Игорь", "Васильев", 2012, 41, "Бабочки"),
                new Participant(4, "Лёша", "Сидоров", 2012, 40, "Лягушки"),
                new Participant(5, "Игнат", "Теренко", 2012, 41, "Травушка")
        );

        Set<Category> categories = new CategoryService().createCategories(participants);

        Printer<Participant> printer = new Printer<>();
        categories.stream()
                .filter(c -> !c.getParticipants().isEmpty())
                .forEach(c -> printer.printWithCategories(
                        c.getParticipants(),
                        c.getAgeCategory(),
                        c.getWeightCategory()
                ));
    }
}
