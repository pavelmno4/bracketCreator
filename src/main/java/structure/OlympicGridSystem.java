package structure;

import entity.Participant;
import one.util.streamex.StreamEx;

import java.util.ArrayList;
import java.util.List;

public class OlympicGridSystem implements GridSystem<Participant> {
    private final List<Participant> firstList;
    private final List<Participant> secondList;
    private final List<Participant> intermediateList = new ArrayList<>();

    private static final Participant EMPTY_PRT = new Participant(-1, "", " ", -1, -1, " ");

    public OlympicGridSystem(List<Participant> participants) {
        firstList = StreamEx.of(participants)
                .distinct(Participant::getTeam)
                .toList();

        secondList = StreamEx.of(participants)
                .filter(p -> !firstList.contains(p))
                .toList();

        int circles = (int) Math.ceil(customLog(2, participants.size()));
        int countOfPositions = (int) Math.pow(2, circles);

        for (int i = 0; i < countOfPositions; i++) {
            intermediateList.add(EMPTY_PRT);
        }
    }

    @Override
    public List<Participant> create() {
        fillTheIntermediateListFromFirst();

        // Попробовать сделать рекурсивно для меньшего подсписка
        // **
        List<Participant> a = intermediateList.subList(0, (intermediateList.size() / 2));
        List<Participant> b = intermediateList.subList((intermediateList.size() / 2), intermediateList.size());

        for (Participant sp : secondList) {
            if (!StreamEx.of(a)
                    .filter(p -> p.getId() != -1)
                    .map(Participant::getTeam)
                    .has(sp.getTeam())
            ) {
                fillFromSecondList(sp, a);
            } else {
                fillFromSecondList(sp, b);
            }
        }

        return StreamEx.of(a).append(b).toList();
        // **
    }

    private static double customLog(int base, int logNumber) {
        return (Math.log(logNumber) / Math.log(base));
    }

    private void fillTheIntermediateListFromFirst() {
        int ind = 0;

        ind = fillFromFirstList(ind, 0);
        fillFromFirstList(ind, 1);
    }

    private int fillFromFirstList(int ind, int remainderOfDivision) {
        int index = ind;

        for (int i = 0; i < intermediateList.size(); i++) {
            if (i % 2 == remainderOfDivision && index < firstList.size()) {
                intermediateList.set(i, firstList.get(index));
                index++;
            }
        }
        return index;
    }

    private void fillFromSecondList(Participant p, List<Participant> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == -1) {
                list.set(i, p);
                break;
            }
        }
    }
}
