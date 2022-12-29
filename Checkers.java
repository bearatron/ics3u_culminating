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
        while (true) {
            g.mainMenu();
            if (choice == 1) {

            }
            else if (choice == 2) {
            }
            else if (choice == 3) {
                g.instructions();
            }
            else {
                g.goodbye();
            }
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
        c.fillRoundRect(282, 678, 30, 30, 10, 10);
        c.fillRoundRect(405, 678, 30, 30, 10, 10);
        c.fillRoundRect(643, 675, 95, 30, 10, 10);
        c.setColor(new Color(0, 0, 0));
        c.drawRoundRect(282, 678, 30, 30, 10, 10);
        c.drawRoundRect(405, 678, 30, 30, 10, 10);
        c.drawRoundRect(643, 675, 95, 30, 10, 10);
        c.setFont(new Font ("Serif", Font.BOLD, 26));
        c.setColor(new Color(0, 0, 0));
        c.drawString("Use     w     and     s     to navigate and   ENTER   to select", 215, 700);
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
    public void instructions() {
        int page = 1;
        while (true) {
            char next;
            if (page == 1) {
                c.setColor(new Color(182,215,168));
                c.fillRect(0, 0, 1024, 728);
                c.setColor(new Color(0, 0, 0));
                c.fillRoundRect(50, 50, 628, 628, 10, 10);
                c.setColor(new Color(230, 202, 175));
                c.fillRect(60, 60, 608, 608);
                c.setColor(new Color(145, 95, 47));
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        c.setColor(new Color(145, 95, 47));
                        c.fillRect(136 + 152 * i, 60 + 152 * j, 76, 76);
                        if (j < 2) {
                            c.setColor(new Color(0, 0, 0));
                            c.fillOval(148 + 152 * i, 72 + 152 * j, 52, 52);
                            c.setColor(new Color(67, 67, 67));
                            c.fillOval(151 + 152 * i, 75 + 152 * j, 46, 46);
                        }
                        if (j == 3) {
                            c.setColor(new Color(102, 0, 0));
                            c.fillOval(148 + 152 * i, 72 + 152 * j, 52, 52);
                            c.setColor(new Color(204, 0, 0));
                            c.fillOval(151 + 152 * i, 75 + 152 * j, 46, 46);
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        c.setColor(new Color(145, 95, 47));
                        c.fillRect(60 + 152 * i, 136 + 152 * j, 76, 76);
                        if (j == 0) {
                            c.setColor(new Color(0, 0, 0));
                            c.fillOval(72 + 152 * i, 148 + 152 * j, 52, 52);
                            c.setColor(new Color(67, 67, 67));
                            c.fillOval(75 + 152 * i, 151 + 152 * j, 46, 46);
                        }
                        if (j > 1) {
                            c.setColor(new Color(102, 0, 0));
                            c.fillOval(72 + 152 * i, 148 + 152 * j, 52, 52);
                            c.setColor(new Color(204, 0, 0));
                            c.fillOval(75 + 152 * i, 151 + 152 * j, 46, 46);
                        }
                    }
                }
                c.setColor(new Color(0, 0, 0));
                c.setFont(new Font("Serif", Font.BOLD, 40));
                c.drawString("Setup", 710, 130);
                c.setFont(new Font("Serif", Font.PLAIN, 30));
                c.drawString("Checkers is a board game", 710, 200);
                c.drawString("for two players. One", 710, 235);
                c.drawString("player has the red pieces,", 710, 270);
                c.drawString("and the other has the", 710, 305);
                c.drawString("black pieces. At the start", 710, 340);
                c.drawString("of the game, each of the", 710, 375);
                c.drawString("set up as shown on ", 710, 410);
                c.drawString("board.", 710, 445);
                c.setColor(new Color(255, 255, 255));
                c.fillRoundRect(963, 637, 30, 30, 10, 10);
                c.setColor(new Color(0, 0, 0));
                c.drawRoundRect(963, 637, 30, 30, 10, 10);
                c.setFont(new Font("Serif", Font.BOLD, 26));
                c.drawString("Next >    d", 870, 660);
            }
            if (page == 2) {
                c.setColor(new Color(182,215,168));
                c.fillRect(0, 0, 1024, 728);
                c.setColor(new Color(0, 0, 0));
                c.fillRoundRect(50, 50, 628, 628, 10, 10);
                c.setColor(new Color(230, 202, 175));
                c.fillRect(60, 60, 608, 608);
                c.setColor(new Color(145, 95, 47));
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        c.setColor(new Color(145, 95, 47));
                        c.fillRect(136 + 152 * i, 60 + 152 * j, 76, 76);
                        if (j < 2) {
                            c.setColor(new Color(0, 0, 0));
                            c.fillOval(148 + 152 * i, 72 + 152 * j, 52, 52);
                            c.setColor(new Color(67, 67, 67));
                            c.fillOval(151 + 152 * i, 75 + 152 * j, 46, 46);
                        }
                        if (j == 3) {
                            c.setColor(new Color(102, 0, 0));
                            c.fillOval(148 + 152 * i, 72 + 152 * j, 52, 52);
                            c.setColor(new Color(204, 0, 0));
                            c.fillOval(151 + 152 * i, 75 + 152 * j, 46, 46);
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        c.setColor(new Color(145, 95, 47));
                        c.fillRect(60 + 152 * i, 136 + 152 * j, 76, 76);
                        if (j == 0) {
                            c.setColor(new Color(0, 0, 0));
                            c.fillOval(72 + 152 * i, 148 + 152 * j, 52, 52);
                            c.setColor(new Color(67, 67, 67));
                            c.fillOval(75 + 152 * i, 151 + 152 * j, 46, 46);
                        }
                        if (j > 1) {
                            if (j == 2 && i == 0) {
                                continue;
                            }
                            c.setColor(new Color(102, 0, 0));
                            c.fillOval(72 + 152 * i, 148 + 152 * j, 52, 52);
                            c.setColor(new Color(204, 0, 0));
                            c.fillOval(75 + 152 * i, 151 + 152 * j, 46, 46);
                        }
                    }
                }
                c.setColor(new Color(102, 0, 0));
                c.fillOval(148, 72 + 152 * 2, 52, 52);
                c.setColor(new Color(204, 0, 0));
                c.fillOval(151, 75 + 152 * 2, 46, 46);
                c.setColor(new Color(255, 255, 255));
                int[] xPoints1 = {96, 100, 148, 144};
                int[] yPoints1 = {476, 480, 432, 428};
                c.fillPolygon(xPoints1, yPoints1, 4);
                int[] xPoints2 = {156, 126, 156};
                int[] yPoints2 = {420, 420, 450};
                c.fillPolygon(xPoints2, yPoints2, 3);
                c.drawLine(98, 478,131,440);
                c.setColor(new Color(0, 0, 0));
                c.setFont(new Font("Serif", Font.BOLD, 40));
                c.drawString("Movement", 710, 130);
                c.setFont(new Font("Serif", Font.PLAIN, 30));
                c.drawString("A turn consists of", 710, 200);
                c.drawString("moving one checkers", 710, 235);
                c.drawString("piece. A checker can only", 710, 270);
                c.drawString("move diagonally forwards", 710, 305);
                c.drawString("one space in either", 710, 340);
                c.drawString("direction (diagonally to", 710, 375);
                c.drawString("the left or to the", 710, 410);
                c.drawString("right). A sample move", 710, 445);
                c.drawString("is shown on the board.", 710, 480);
                c.setColor(new Color(255, 255, 255));
                c.fillRoundRect(963, 637, 30, 30, 10, 10);
                c.setColor(new Color(0, 0, 0));
                c.drawRoundRect(963, 637, 30, 30, 10, 10);
                c.setFont(new Font("Serif", Font.BOLD, 26));
                c.drawString("Next >    d", 870, 660);
                c.setColor(new Color(255, 255, 255));
                c.fillRoundRect(692, 637, 30, 30, 10, 10);
                c.setColor(new Color(0, 0, 0));
                c.drawRoundRect(692, 637, 30, 30, 10, 10);
                c.drawString("a    < Prev", 700, 660);
            }
            if (page == 3) {
                c.setColor(new Color(182,215,168));
                c.fillRect(0, 0, 1024, 728);
                c.setColor(new Color(0, 0, 0));
                c.fillRoundRect(50, 50, 628, 628, 10, 10);
                c.setColor(new Color(230, 202, 175));
                c.fillRect(60, 60, 608, 608);
                c.setColor(new Color(145, 95, 47));
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        c.setColor(new Color(145, 95, 47));
                        c.fillRect(136 + 152 * i, 60 + 152 * j, 76, 76);
                        if (j < 2) {
                            if (j == 1 && i == 1) {
                                continue;
                            }
                            c.setColor(new Color(0, 0, 0));
                            c.fillOval(148 + 152 * i, 72 + 152 * j, 52, 52);
                            c.setColor(new Color(67, 67, 67));
                            c.fillOval(151 + 152 * i, 75 + 152 * j, 46, 46);
                        }
                        if (j == 3) {
                            c.setColor(new Color(102, 0, 0));
                            c.fillOval(148 + 152 * i, 72 + 152 * j, 52, 52);
                            c.setColor(new Color(204, 0, 0));
                            c.fillOval(151 + 152 * i, 75 + 152 * j, 46, 46);
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        c.setColor(new Color(145, 95, 47));
                        c.fillRect(60 + 152 * i, 136 + 152 * j, 76, 76);
                        if (j == 0) {
                            c.setColor(new Color(0, 0, 0));
                            c.fillOval(72 + 152 * i, 148 + 152 * j, 52, 52);
                            c.setColor(new Color(67, 67, 67));
                            c.fillOval(75 + 152 * i, 151 + 152 * j, 46, 46);
                        }
                        if (j > 1) {
                            if (j == 2 && i == 0) {
                                continue;
                            }
                            c.setColor(new Color(102, 0, 0));
                            c.fillOval(72 + 152 * i, 148 + 152 * j, 52, 52);
                            c.setColor(new Color(204, 0, 0));
                            c.fillOval(75 + 152 * i, 151 + 152 * j, 46, 46);
                        }
                    }
                }
                c.setColor(new Color(102, 0, 0));
                c.fillOval(148, 72 + 152 * 2, 52, 52);
                c.setColor(new Color(204, 0, 0));
                c.fillOval(151, 75 + 152 * 2, 46, 46);
                c.setColor(new Color(0, 0, 0));
                c.fillOval(72 + 152 * 1, 148 + 152 * 1, 52, 52);
                c.setColor(new Color(67, 67, 67));
                c.fillOval(75 + 152 * 1, 151 + 152 * 1, 46, 46);
                c.setColor(new Color(255, 255, 255));
                int[] xPoints1 = {96 + 114, 100 + 114, 148 + 152+20, 144 + 152+20};
                int[] yPoints1 = {476 - 114, 480 - 114, 432 - 152-20, 428 - 152-20};
                c.fillPolygon(xPoints1, yPoints1, 4);
                int[] xPoints2 = {156 + 152+20, 126 + 152+20, 156 + 152+20};
                int[] yPoints2 = {420 - 152-20, 420 - 152-20, 450 - 152-20};
                c.fillPolygon(xPoints2, yPoints2, 3);
                c.setColor(new Color(0, 0, 0));
                c.setFont(new Font("Serif", Font.BOLD, 40));
                c.drawString("Capture", 710, 130);
                c.setFont(new Font("Serif", Font.PLAIN, 30));
                c.drawString("You can capture", 710, 200);
                c.drawString("your opponent’s pieces by", 710, 235);
                c.drawString("jumping over them. In", 710, 270);
                c.drawString("this example, the red", 710, 305);
                c.drawString("piece can jump over the", 710, 340);
                c.drawString("black one, thereby", 710, 375);
                c.drawString("capturing the black piece.", 710, 410);
                c.drawString("It is then removed from", 710, 445);
                c.drawString("the board. The goal of", 710, 480);
                c.drawString("the game is to capture all", 710, 515);
                c.drawString("of your opponent’s pieces.", 710, 550);
                c.setColor(new Color(255, 255, 255));
                c.fillRoundRect(963, 637, 30, 30, 10, 10);
                c.setColor(new Color(0, 0, 0));
                c.drawRoundRect(963, 637, 30, 30, 10, 10);
                c.setFont(new Font("Serif", Font.BOLD, 26));
                c.drawString("Next >    d", 870, 660);
                c.setColor(new Color(255, 255, 255));
                c.fillRoundRect(692, 637, 30, 30, 10, 10);
                c.setColor(new Color(0, 0, 0));
                c.drawRoundRect(692, 637, 30, 30, 10, 10);
                c.drawString("a    < Prev", 700, 660);
            }
            if (page == 4) {
                c.setColor(new Color(182,215,168));
                c.fillRect(0, 0, 1024, 728);
                c.setColor(new Color(0, 0, 0));
                c.fillRoundRect(50, 50, 628, 628, 10, 10);
                c.setColor(new Color(230, 202, 175));
                c.fillRect(60, 60, 608, 608);
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        c.setColor(new Color(145, 95, 47));
                        c.fillRect(136 + 152 * i, 60 + 152 * j, 76, 76);
                    }
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        c.setColor(new Color(145, 95, 47));
                        c.fillRect(60 + 152 * i, 136 + 152 * j, 76, 76);
                    }
                }
                c.setColor(new Color(0, 0, 0));
                c.fillOval(148 + 152 * 1, 72 + 152 * 2, 52, 52);
                c.setColor(new Color(67, 67, 67));
                c.fillOval(151 + 152 * 1, 75 + 152 * 2, 46, 46);
                c.setColor(new Color(0, 0, 0));
                c.fillOval(148 + 152 * 1, 72 + 152 * 3, 52, 52);
                c.setColor(new Color(67, 67, 67));
                c.fillOval(151 + 152 * 1, 75 + 152 * 3, 46, 46);
                c.setColor(new Color(0, 0, 0));
                c.fillOval(148 + 152 * 2, 72 + 152 * 2, 52, 52);
                c.setColor(new Color(67, 67, 67));
                c.fillOval(151 + 152 * 2, 75 + 152 * 2, 46, 46);
                c.setColor(new Color(0, 0, 0));
                c.fillOval(148 + 152 * 3, 72 + 152 * 2, 52, 52);
                c.setColor(new Color(67, 67, 67));
                c.fillOval(151 + 152 * 3, 75 + 152 * 2, 46, 46);
                c.setColor(new Color(102, 0, 0));
                c.fillOval(148 + 152 * 0, 72 + 152 * 3, 52, 52);
                c.setColor(new Color(204, 0, 0));
                c.fillOval(151 + 152 * 0, 75 + 152 * 3, 46, 46);
                c.setColor(new Color(102, 0, 0));
                c.fillOval(148 + 152 * 2, 72 + 152 * 0, 52, 52);
                c.setColor(new Color(204, 0, 0));
                c.fillOval(151 + 152 * 2, 75 + 152 * 0, 46, 46);
                c.setColor(new Color(246,178,107));
                int[] xPoints1 = {60 + 38+76*5, 60 + 38+76*5 + 5, 60 + 38+76*5 + 11, 60 + 38+76*5 + 11, 60 + 38+76*5 - 11, 60 + 38+76*5 - 11, 60 + 38+76*5 - 5};
                int[] yPoints1 = {60 + 38 - 6, 60 + 38, 60 + 38 - 3, 60 + 38 + 6, 60 + 38 + 6, 60 + 38 - 3, 60 + 38};
                c.fillPolygon(xPoints1, yPoints1, 7);
                c.setColor(new Color(0, 0, 0));
                c.fillOval(72 + 152 * 0, 148 + 152 * 0, 52, 52);
                c.setColor(new Color(67, 67, 67));
                c.fillOval(75 + 152 * 0, 151 + 152 * 0, 46, 46);
                c.setColor(new Color(0, 0, 0));
                c.fillOval(72 + 152 * 1, 148 + 152 * 1, 52, 52);
                c.setColor(new Color(67, 67, 67));
                c.fillOval(75 + 152 * 1, 151 + 152 * 1, 46, 46);
                c.setColor(new Color(0, 0, 0));
                c.fillOval(72 + 152 * 3, 148 + 152 * 1, 52, 52);
                c.setColor(new Color(67, 67, 67));
                c.fillOval(75 + 152 * 3, 151 + 152 * 1, 46, 46);
                c.setColor(new Color(102, 0, 0));
                c.fillOval(72 + 152 * 0, 148 + 152 * 1, 52, 52);
                c.setColor(new Color(204, 0, 0));
                c.fillOval(75 + 152 * 0, 151 + 152 * 1, 46, 46);
                c.setColor(new Color(102, 0, 0));
                c.fillOval(72 + 152 * 2, 148 + 152 * 2, 52, 52);
                c.setColor(new Color(204, 0, 0));
                c.fillOval(75 + 152 * 2, 151 + 152 * 2, 46, 46);
                c.setColor(new Color(102, 0, 0));
                c.fillOval(72 + 152 * 0, 148 + 152 * 2, 52, 52);
                c.setColor(new Color(204, 0, 0));
                c.fillOval(75 + 152 * 0, 151 + 152 * 2, 46, 46);
                c.setColor(new Color(255, 255, 255));
                int[] xPoints2 = {60 + 38+76*5 + 18, 60 + 38+76*5 + 22, 60 + 38+76*5 + 22 + 50, 60 + 38+76*5 + 18 + 50};
                int[] yPoints2 = {60 + 38 + 22, 60 + 38 + 18, 60 + 38 + 18 + 50, 60 + 38 + 22 + 50};
                c.fillPolygon(xPoints2, yPoints2, 4);
                int[] xPoints3 = {60 + 38+76*6, 60 + 38+76*6, 30 + 38+76*6};
                int[] yPoints3 = {60 + 38 + 76, 30 + 38 + 76, 60 + 38 + 76};
                c.fillPolygon(xPoints3, yPoints3, 3);
                c.setColor(new Color(0, 0, 0));
                c.setFont(new Font("Serif", Font.BOLD, 40));
                c.drawString("King", 710, 130);
                c.setFont(new Font("Serif", Font.PLAIN, 30));
                c.drawString("If your piece reaches the", 710, 200);
                c.drawString("last row, it becomes a", 710, 235);
                c.drawString("king. Kings can move or", 710, 270);
                c.drawString("capture one space", 710, 305);
                c.drawString("diagonally in any", 710, 340);
                c.drawString("direction. They are not", 710, 375);
                c.drawString("limited to moving", 710, 410);
                c.drawString("forwards only.", 710, 445);
                c.setColor(new Color(255, 255, 255));
                c.fillRoundRect(963, 637, 30, 30, 10, 10);
                c.setColor(new Color(0, 0, 0));
                c.drawRoundRect(963, 637, 30, 30, 10, 10);
                c.setFont(new Font("Serif", Font.BOLD, 26));
                c.drawString("Return >    d", 844, 660);
                c.setColor(new Color(255, 255, 255));
                c.fillRoundRect(692, 637, 30, 30, 10, 10);
                c.setColor(new Color(0, 0, 0));
                c.drawRoundRect(692, 637, 30, 30, 10, 10);
                c.drawString("a    < Prev", 700, 660);
            }
            next = c.getChar();
            if (next == 100) {
                c.clear();
                page++;
                if (page == 5) {
                    choice = 1;
                    return;
                }
            }
            if (next == 97) {
                if (page > 1) {
                    page--;
                    c.clear();
                }
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
