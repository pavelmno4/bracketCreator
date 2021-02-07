package service;

import entity.AgeCategory;
import entity.Grid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Printer<T> {

    public void print(List<T> list) {
        BufferedImage image = generalPrint(list);

        try {
            ImageIO.write(image, "png", new File("example/grid_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printWithCategories(List<T> list, AgeCategory age, int weight) {
        BufferedImage image = generalPrint(list);

        try {
            ImageIO.write(image, "png", new File("example/" + age.name() + "_" + weight + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage generalPrint(List<T> list) {
        Grid grid = selectGrid(list.size());
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(grid.getPath()));
            Graphics g = image.getGraphics();
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.setColor(Color.BLACK);

            int startY = grid.getStartY();

            for (T e : list) {
                int fontHeight = 0;

                for (String line : e.toString().split(" /")) {
                    g.drawString(line, grid.getStartX(), startY += fontHeight);
                    fontHeight = g.getFontMetrics().getHeight();
                }
                startY += grid.getStep();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private Grid selectGrid(int size) {
        return Arrays.stream(Grid.values())
                .filter(g -> g.getAmount() >= size)
                .collect(Collectors.toList())
                .get(0);
    }
}
