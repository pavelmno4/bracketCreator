package structure;

import entity.Participant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pair {
    private Participant participantOne;
    private Participant participantTwo;
}
