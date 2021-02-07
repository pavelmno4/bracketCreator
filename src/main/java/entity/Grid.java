package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grid {
    GRID_8(8,
            "/home/pkozlov/IdeaProjects/bracketCreator/src/main/resources/grid/teams_08.png",
            62,
            86,
            24
    ),
    GRID_16(16,
            "/home/pkozlov/IdeaProjects/bracketCreator/src/main/resources/grid/teams_16.png",
            62,
            86,
            24
    ),
    GRID_32(32,
            "/home/pkozlov/IdeaProjects/bracketCreator/src/main/resources/grid/teams_32.png",
            62,
            85,
            25
    );

    private final int amount;
    private final String path;
    private final int startX;
    private final int startY;
    private final int step;
}
