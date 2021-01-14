package structure;

import entity.Participant;

import java.util.List;

public class OlympicGrid implements Grid {
    private List<Participant> participants;
    private int size;

    public OlympicGrid(List<Participant> participants) {
        this.participants = participants;

        int coefficient = participants.size() / 32;

        if (coefficient > 0.5 & coefficient <= 1) {
            size = 32;
        } else if (coefficient > 0.25 & coefficient <= 0.5) {
            size = 16;
        } else {
            size = 8;
        }
    }

    @Override
    public void create() {


    }
}
