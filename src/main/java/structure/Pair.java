package structure;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<T> {
    private T prtOne;
    private T prtTwo;
}
