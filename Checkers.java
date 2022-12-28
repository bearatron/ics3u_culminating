// Names: Ethan Diep and Glen Lin
// Date: December 23, 2022
// Teacher: Ms. Basaraba
// Description: This program makes a checkers game in the Console window

import java.awt.*;
import hsa.*;

public class Checkers {
    static Console c;
    static int choice = 1;
    public static void main(String[] args) {
        Checkers g = new Checkers();
        g.splashScreen();
        g.mainMenu();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {

        }
        else {
            g.goodbye();
        }
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
        c.setColor(new Color(182,215,168));
        c.fillRect(0, 0, 1024, 728);
        c.setColor(new Color(0, 0, 0));
        c.setFont(new Font ("SansSerif", Font.BOLD, 75));
        c.drawString("CHECKERS", 305, 175);
        drawChecker(210, 155, true);
        drawChecker(210, 125, false);
        drawChecker(360, 185, true);
        drawChecker(285, 255, false);
        drawChecker(585, 225, false);
        drawChecker(665, 165, true);
        c.setColor(new Color(255, 255, 255));
        c.fillRoundRect(280, 675, 30, 30, 10, 10);
        c.fillRoundRect(397, 675, 30, 30, 10, 10);
        c.fillRoundRect(634, 675, 95, 30, 10, 10);
        c.setColor(new Color(0, 0, 0));
        c.drawRoundRect(280, 675, 30, 30, 10, 10);
        c.drawRoundRect(397, 675, 30, 30, 10, 10);
        c.drawRoundRect(634, 675, 95, 30, 10, 10);
        c.setFont(new Font ("Serif", Font.BOLD, 26));
        c.setColor(new Color(0, 0, 0));
        c.drawString("Use    W    and    S    to navigate and   ENTER   to select", 215, 700);
        c.setFont(new Font ("Serif", Font.PLAIN, 30));
        while (true) {
            c.setColor(new Color(182,215,168));
            c.fillRect(300, 320, 400, 300);
            c.setColor(new Color(0, 0, 0));
            if (choice == 1) {
                c.setFont(new Font ("Serif", Font.BOLD, 30));
                c.drawString("New Game", 433, 364);
                int[] xPoints1 = {380, 380, 417};
                int[] yPoints1 = {344, 364, 354};
                c.fillPolygon(xPoints1, yPoints1, 3);
                int[] xPoints2 = {624, 624, 587};
                int[] yPoints2 = {344, 364, 354};
                c.fillPolygon(xPoints2, yPoints2, 3);
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("Load Game", 430, 434);
                c.drawString("Instructions", 425, 504);
                c.drawString("Quit Game", 430, 574);
            }
            else if (choice == 2) {
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("New Game", 433, 364);
                c.setFont(new Font ("Serif", Font.BOLD, 30));
                c.drawString("Load Game", 430, 434);
                int[] xPoints1 = {378, 378, 415};
                int[] yPoints1 = {414, 434, 424};
                c.fillPolygon(xPoints1, yPoints1, 3);
                int[] xPoints2 = {630, 630, 593};
                int[] yPoints2 = {414, 434, 424};
                c.fillPolygon(xPoints2, yPoints2, 3);
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("Instructions", 425, 504);
                c.drawString("Quit Game", 430, 574);
            }
            else if (choice == 3) {
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("New Game", 433, 364);
                c.drawString("Load Game", 430, 434);
                c.setFont(new Font ("Serif", Font.BOLD, 30));
                c.drawString("Instructions", 425, 504);
                int[] xPoints1 = {374, 374, 411};
                int[] yPoints1 = {484, 504, 494};
                c.fillPolygon(xPoints1, yPoints1, 3);
                int[] xPoints2 = {632, 632, 595};
                int[] yPoints2 = {484, 504, 494};
                c.fillPolygon(xPoints2, yPoints2, 3);
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("Quit Game", 430, 574);
            }
            else {
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("New Game", 433, 364);
                c.drawString("Load Game", 430, 434);
                c.drawString("Instructions", 425, 504);
                c.setFont(new Font ("Serif", Font.BOLD, 30));
                c.drawString("Quit Game", 430, 574);
                int[] xPoints1 = {378, 378, 415};
                int[] yPoints1 = {554, 574, 564};
                c.fillPolygon(xPoints1, yPoints1, 3);
                int[] xPoints2 = {630, 630, 593};
                int[] yPoints2 = {554, 574, 564};
                c.fillPolygon(xPoints2, yPoints2, 3);
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
                return;
            }
        }
    }

    public void goodbye() {
        c.setColor(new Color(182,215,168));
        c.fillRect(0, 0, 1024, 728);
        c.setColor(new Color(0, 0, 0));
        c.setFont(new Font ("Serif", Font.BOLD, 75));
        c.drawString("Thanks for playing!", 190, 175);
        c.setFont(new Font ("Serif", Font.PLAIN, 35));
        c.drawString("This program was made by Ethan Diep and Glen Lin,", 150, 355);
        c.drawString("submitted on January 18, 2022 as a culminating\n", 180, 400);
        c.drawString("assignment for ICS3U.", 320, 445);
        drawChecker(210, 555, true);
        drawChecker(210, 525, false);
        drawChecker(360, 585, true);
        drawChecker(285, 655, false);
        drawChecker(585, 625, false);
        drawChecker(665, 565, true);
        c.setFont(new Font ("Serif", Font.BOLD, 30));
        c.setColor(new Color(0, 0, 0));
        c.drawString("Press any key to exit.", 370, 550);
        char quit = c.getChar();
        System.exit(0);
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
