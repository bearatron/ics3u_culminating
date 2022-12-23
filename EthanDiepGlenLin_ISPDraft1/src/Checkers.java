// Names: Ethan Diep and Glen Lin
// Date: December 23, 2022
// Teacher: Ms. Basaraba
// Description: This program makes a checkers game in the Console window

import java.awt.*;

public class Checkers {
    static Console c;

    public static void main(String[] args) {
        Checkers g = new Checkers();
        g.splashScreen();
    }

    public Checkers() {
        c = new Console(39, 128);
    }

    public void splashScreen() {
        c.setColor(new Color(182,215,168));
        c.fillRect(0, 0, 1024, 728);

        checkersFall1();
        checkersFall2();
        textFall();
        transition();
    }

    public void checkersFall1() {
        CheckersFall1 cf1 = new CheckersFall1(c);
        cf1.start();
    }

    public void checkersFall2() {
        CheckersFall2 cf2 = new CheckersFall2(c);
        cf2.start();
        try {
            cf2.join();
        } catch (Exception e) {}
    }

    public void textFall() {
        TextFall tf = new TextFall(c);
        tf.start();
    }

    public void transition() {
        Transition tr = new Transition(c);
        tr.start();
    }

    public static void drawChecker(int x, int y, boolean isRed) {
        if (isRed) {
            c.setColor(new Color(224, 102, 102));
        } else {
            c.setColor(new Color(102,102,102));
        }

        c.fillRect(x, y + 20, 111, 20);

        if (isRed) {
            c.setColor(new Color(224, 102, 102));
        } else {
            c.setColor(new Color(102,102,102));
        }

        c.fillOval(x, y + 22, 111, 37);

        if (isRed) {
            c.setColor(new Color(204,0,0));
        } else {
            c.setColor(new Color(67,67,67));
        }

        c.fillOval(x, y, 111, 37);
    }

    public static void animateFallingChecker(int x, int fromY, int toY, boolean isRed, double speed, double change, int[][] existingCheckers) {
        for (int y = fromY; y <= toY; y += (int) speed) {
            // background
            c.setColor(new Color(182,215,168));
            c.fillRect(x, 0, 111, toY + 70);

            for (int[] existingChecker : existingCheckers) {
                drawChecker(existingChecker[0], existingChecker[1], existingChecker[2] != 0);
            }

            drawChecker(x, y, isRed);

            try {
                Thread.sleep(20);
            } catch (Exception e) {

            }

            speed *= change; // increasing speed
        }

        drawChecker(x, toY, isRed);
    }
}
