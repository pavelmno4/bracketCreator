package service;

import entity.Grid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PartPrinter<T> {
    public void print(List<T> list) {
        Grid grid = selectGrid(list.size());

        try {
            BufferedImage image = ImageIO.read(new File(grid.getPath()));
            Graphics g = image.getGraphics();
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.setColor(Color.BLACK);

            int startY = grid.getStartY();

            for (T e : list) {
                g.drawString(e.toString(), grid.getStartX(), startY += grid.getStep());
            }

            ImageIO.write(image, "png", new File("example/" + grid.name() + "." + Math.random() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Grid selectGrid(int size) {
        return Arrays.stream(Grid.values())
                .filter(g -> g.getAmount() >= size)
                .collect(Collectors.toList())
                .get(0);
    }
}
