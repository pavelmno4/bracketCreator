package service;

import entity.AgeCategory;
import entity.Category;
import entity.Participant;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryService {
    private final int YEAR_NOW = LocalDate.now().getYear();
    private final Set<Category> categories = new HashSet<>();

    public Set<Category> createCategories(List<Participant> participants) {
        for (AgeCategory ac : AgeCategory.values()) {
            for (int weight : ac.getWeights()) {
                List<Participant> prts =
                        participants.stream()
                                .filter(p -> ((YEAR_NOW - p.getBirthYear()) >= ac.getLowAgeLimit() &
                                        (YEAR_NOW - p.getBirthYear()) <= ac.getHighAgeLimit()))
                                .filter(p -> weightCategory(p.getWeight(), ac.getWeights()) == weight)
                                .collect(Collectors.toList());

                categories.add(new Category(ac, weight, prts));
            }
        }
        return categories;
    }

    private static int weightCategory(int weight, List<Integer> weightCategories) {
        List<Integer> cts =
                weightCategories.stream()
                        .filter(c -> c >= weight)
                        .collect(Collectors.toList());
        return cts.get(0);
    }
}
