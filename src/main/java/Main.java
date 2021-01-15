import structure.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int a = 5 % 2;
//        System.out.println(a);

//        System.out.println(Math.ceil(customLog(2, 4)));

        List<Integer> participants = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(createBracket(participants));


    }

    public static double customLog(int base, int logNumber) {
        return (Math.log(logNumber) / Math.log(base));
    }

    public static List<Pair<Integer>> createBracket(List<Integer> participants) {
        int circle = (int) Math.ceil(customLog(2, participants.size()));
        int countOfPositions = (int) Math.pow(2, circle);

        List<Pair<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < countOfPositions / 2; i++) {
            try {
                pairs.add(new Pair<>(participants.get(i), participants.get(i + (countOfPositions / 2))));
            } catch (ArrayIndexOutOfBoundsException e) {
                pairs.add(new Pair<>(participants.get(i), null));
            }
        }

        return pairs;


    }
}
