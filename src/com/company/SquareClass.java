package com.company;

import java.awt.*;
import java.util.Random;

public class SquareClass extends FiguraClass{

    public SquareClass(int x, int y, int size, Graphics g) {
        super(x, y, size, g);
    }

    @Override
    public void Draw() {
        super.Draw();
        g.setColor(new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(256)));
        super.g.fillRect(super.x,super.y,super.size,super.size);
    }
}
