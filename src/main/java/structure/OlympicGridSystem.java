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
        int index = 0;

        for (Participant p : firstList) {
            intermediateList.set(index, p);
            index += 2;
        }

        List<Participant> a = intermediateList.subList(0, (intermediateList.size() / 2));
        List<Participant> b = intermediateList.subList((intermediateList.size() / 2), intermediateList.size());


        for (Participant sp : secondList) {
            int count = 0;

            if (!StreamEx.of(a)
                    .filter(p -> p.getId() != -1)
                    .map(Participant::getTeam)
                    .has(sp.getTeam())
            ) {
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i).getId() == -1 && count == 0) {
                        a.set(i, sp);
                        count++;
                    }
                }

            } else {
                for (int i = 0; i < b.size(); i++) {
                    if (b.get(i).getId() == -1 && count == 0) {
                        b.set(i, sp);
                        count++;
                    }
                }
            }
        }

        return StreamEx.of(a).append(b).toList();
    }

    private static double customLog(int base, int logNumber) {
        return (Math.log(logNumber) / Math.log(base));
    }
}
