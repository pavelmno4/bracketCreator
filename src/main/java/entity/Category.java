package entity;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private final AgeCategory ageCategory;
    private final int weightCategory;
    private final List<Participant> participants;
}
