package structure;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<P> {
    private P participantOne;
    private P participantTwo;
}
