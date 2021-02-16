package structure;

import entity.Participant;
import one.util.streamex.StreamEx;

import java.util.ArrayList;
import java.util.List;

public class OlympicGridSystem_v2 {
    private final List<Participant> firstList;
    private final List<Participant> secondList;
    private final List<Participant> intermediateList = new ArrayList<>();

    private static final Participant EMPTY_PRT = new Participant(-1, "", " ", -1, -1, " ");

    public OlympicGridSystem_v2(List<Participant> participants) {
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

    public List<Participant> recursiveCreate(List<Participant> list) {
        List<Participant> listOne = getParticipants(list);

        List<Participant> leftList = new ArrayList<>(listOne.subList(0, (listOne.size() / 2)));
        List<Participant> rightList = new ArrayList<>(listOne.subList((listOne.size() / 2), listOne.size()));

        List<Participant> listA = leftList;
        List<Participant> listB = rightList;

        if (listOne.size() > 8) {
            listA = recursiveCreate(leftList);
            listB = recursiveCreate(rightList);
        }

        return StreamEx.of(listA).append(listB).toList();
    }

    private List<Participant> getParticipants(List<Participant> list) {
        List<Participant> intermediateList = new ArrayList<>();
        List<Participant> firstList;
        List<Participant> secondList;

        firstList = StreamEx.of(list)
                .filter(p -> !p.getTeam().equals(" "))
                .distinct(Participant::getTeam)
                .toList();

        secondList = StreamEx.of(list)
                .filter(p -> !firstList.contains(p))
                .toList();

        int circles = (int) Math.ceil(customLog(2, list.size()));
        int countOfPositions = (int) Math.pow(2, circles);

        for (int i = 0; i < countOfPositions; i++) {
            intermediateList.add(EMPTY_PRT);
        }

        int ind = 0;

        for (int i = 0; i < intermediateList.size(); i++) {
            if (i % 2 == 0 && ind < firstList.size()) {
                intermediateList.set(i, firstList.get(ind));
                ind++;
            }
        }

        for (int i = 0; i < intermediateList.size(); i++) {
            if (i % 2 == 1 && ind < firstList.size()) {
                intermediateList.set(i, firstList.get(ind));
                ind++;
            }
        }

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
    }
}
