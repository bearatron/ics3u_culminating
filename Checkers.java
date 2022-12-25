// Names: Ethan Diep and Glen Lin
// Date: December 23, 2022
// Teacher: Ms. Basaraba
// Description: This program makes a checkers game in the Console window

import java.awt.*;
import hsa.*;

public class Checkers {
    static Console c;

    public static void main(String[] args) {
        Checkers g = new Checkers();
        g.splashScreen();
        g.mainMenu();
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

    public void mainMenu() {
        int choice = 1;
        c.setColor(new Color(182,215,168));
        c.fillRect(0, 0, 1024, 728);
        c.setColor(new Color(186,95,14, 125));
        c.fillRect(256, 108, 512, 512);
        c.setColor(new Color(143,45,0, 125));
        c.fillRect(272, 124, 480, 480);
        c.setColor(new Color(65,23,0, 125));
        for (int i = 0; i < 4; i++) {
            c.fillRect(332, 124 + i * 120, 60, 60);
            c.fillRect(452, 124 + i * 120, 60, 60);
            c.fillRect(572, 124 + i * 120, 60, 60);
            c.fillRect(692, 124 + i * 120, 60, 60);
            c.fillRect(272, 184 + i * 120, 60, 60);
            c.fillRect(392, 184 + i * 120, 60, 60);
            c.fillRect(512, 184 + i * 120, 60, 60);
            c.fillRect(632, 184 + i * 120, 60, 60);
        }
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                c.setColor(new Color(204,0,0, 125));
            }
            else if (i <= 1) {
                c.setColor(new Color(67,67,67, 125));
            }
            else {
                continue;
            }
            c.fillOval(332 + 8, 124 + 8 + i * 120, 44, 44);
            c.fillOval(452 + 8, 124 + 8 + i * 120, 44, 44);
            c.fillOval(572 + 8, 124 + 8 + i * 120, 44, 44);
            c.fillOval(692 + 8, 124 + 8 + i * 120, 44, 44);
        }
        for (int i = 0; i < 4; i++) {
            if (i >= 2) {
                c.setColor(new Color(204,0,0, 125));
            }
            else if (i == 0) {
                c.setColor(new Color(67,67,67, 125));
            }
            else {
                continue;
            }
            c.fillOval(272 + 8, 184 + 8 + i * 120, 44, 44);
            c.fillOval(392 + 8, 184 + 8 + i * 120, 44, 44);
            c.fillOval(512 + 8, 184 + 8 + i * 120, 44, 44);
            c.fillOval(632 + 8, 184 + 8 + i * 120, 44, 44);
        }
        c.setColor(new Color(87, 120, 73));
        c.fillRect(312, 50, 400, 90);
        c.setColor(new Color(0, 0, 0));
        c.setFont(new Font ("SansSerif", Font.BOLD, 75));
        c.drawString("Checkers", 345, 125);
        c.setColor(new Color(235,161,86));
        c.fillRect(412, 225, 200, 60);
        c.fillRect(412, 325, 200, 60);
        c.fillRect(412, 425, 200, 60);
        c.fillRect(412, 525, 200, 60);
        c.setFont(new Font ("SansSerif", Font.BOLD, 30));
        while (true) {
            c.setColor(new Color(0, 0, 0));
            if (choice == 1) {
                c.setColor(new Color(87, 120, 73));
                c.drawString("New Game", 433, 264);
                c.setColor(new Color(0, 0, 0));
                c.drawString("Load Game", 430, 364);
                c.drawString("Instructions", 425, 464);
                c.drawString("Quit Game", 430, 564);
            }
            else if (choice == 2) {
                c.drawString("New Game", 433, 264);
                c.setColor(new Color(87, 120, 73));
                c.drawString("Load Game", 430, 364);
                c.setColor(new Color(0, 0, 0));
                c.drawString("Instructions", 425, 464);
                c.drawString("Quit Game", 430, 564);
            }
            else if (choice == 3) {
                c.drawString("New Game", 433, 264);
                c.drawString("Load Game", 430, 364);
                c.setColor(new Color(87, 120, 73));
                c.drawString("Instructions", 425, 464);
                c.setColor(new Color(0, 0, 0));
                c.drawString("Quit Game", 430, 564);
            }
            else {
                c.drawString("New Game", 433, 264);
                c.drawString("Load Game", 430, 364);
                c.drawString("Instructions", 425, 464);
                c.setColor(new Color(87, 120, 73));
                c.drawString("Quit Game", 430, 564);
            }
            char in = c.getChar();
            if (in == 115) {
                choice++;
                if (choice == 5) {
                    choice = 1;
                }
            }
            else if (in == 119) {
                choice--;
                if (choice == 0) {
                    choice = 4;
                }
            }
            else if (in == 10) {
                c.clear();
                break;
            }
        }
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
        try {
            tf.join();
        } catch (Exception e) {}
    }
    public void transition() {
        Transition tr = new Transition(c);
        tr.start();
        try {
            tr.join();
        } catch (Exception e) {}
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
