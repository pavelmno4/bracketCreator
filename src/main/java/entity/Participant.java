package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Participant {
    private long id;
    private String firstName;
    private String lastName;
    private int birthYear;
    private int weight;
    private String team;

    @Override
    public String toString() {
        return lastName + " " + firstName + " /" + team;
    }
}
