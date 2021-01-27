package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum AgeCategory {
    CAT_8_9(8, 9, List.of(23, 25, 27, 30, 34, 38, 42, Integer.MAX_VALUE)),
    CAT_10_11(10, 11, List.of(27, 30, 34, 38, 42, 46, 50, 55, Integer.MAX_VALUE)),
    CAT_12_13(12, 13, List.of(32, 34, 38, 42, 46, 50, 55, 60, 66, Integer.MAX_VALUE)),
    CAT_14_15(14, 15, List.of(32, 35, 38, 42, 47, 53, 59, 66, 73, 85, Integer.MAX_VALUE));

    private final int lowAgeLimit;
    private final int highAgeLimit;
    private final List<Integer> weights;
}
