package structure;

import java.util.ArrayList;
import java.util.List;

public class OlympicGrid<T> implements Grid<T> {
    private final List<T> participants;

    public OlympicGrid(List<T> participants) {
        this.participants = participants;
    }

    private static double customLog(int base, int logNumber) {
        return (Math.log(logNumber) / Math.log(base));
    }

    @Override
    public List<Pair<T>> create() {
        int circles = (int) Math.ceil(customLog(2, participants.size()));
        int countOfPositions = (int) Math.pow(2, circles);

        List<Pair<T>> pairs = new ArrayList<>();

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
