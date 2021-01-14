package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Participant {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;
    private String team;
}
