// Names: Ethan Diep and Glen Lin
// Date: December 23, 2022
// Teacher: Ms. Basaraba
// Description: This program makes a checkers game in the Console window

import java.awt.*;
import hsa.*;

public class Checkers {
    static Console c;
    static int choice = 1;
    static char[][] board = {
        {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
        {'b', '-', 'b', '-', 'b', '-', 'b', '-'},
        {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
        {'e', '-', 'e', '-', 'e', '-', 'e', '-'},
        {'-', 'e', '-', 'e', '-', 'e', '-', 'e'},
        {'r', '-', 'r', '-', 'r', '-', 'r', '-'},
        {'-', 'r', '-', 'r', '-', 'r', '-', 'r'},
        {'r', '-', 'r', '-', 'r', '-', 'r', '-'},
    };
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
        c.setColor(Color.BLACK);
        c.setFont(new Font ("SansSerif", Font.BOLD, 75));
        c.drawString("CHECKERS", 305, 175);
        drawChecker(210, 155, true);
        drawChecker(210, 125, false);
        drawChecker(360, 185, true);
        drawChecker(285, 255, false);
        drawChecker(585, 225, false);
        drawChecker(665, 165, true);
        c.setColor(Color.WHITE);

        // keyboard key symbols
        c.fillRoundRect(272, 675, 30, 30, 10, 10); // w
        c.fillRoundRect(375, 675, 30, 30, 10, 10); // s
        c.fillRoundRect(600, 675, 100, 30, 10, 10); // enter

        // keyboard key symbol outlines
        c.setColor(Color.BLACK);
        c.drawRoundRect(272, 675, 30, 30, 10, 10); // w
        c.drawRoundRect(375, 675, 30, 30, 10, 10); // s
        c.drawRoundRect(600, 675, 100, 30, 10, 10); // enter

        // navigation instructions
        c.setFont(new Font ("Serif", Font.BOLD, 26));
        c.setColor(Color.BLACK);
        c.drawString("Use   W   and   S   to navigate and   ENTER   to select", 215, 700);

        // options
        c.setFont(new Font ("Serif", Font.PLAIN, 30));
        while (true) {
            c.setColor(new Color(182,215,168));
            c.fillRect(300, 320, 400, 300);
            c.setColor(Color.BLACK);
            if (choice == 1) {
                // highlights "New Game"
                c.setFont(new Font ("Serif", Font.BOLD, 30));
                c.drawString("New Game", 433, 364);
                int[] xPoints1 = {380, 380, 417};
                int[] yPoints1 = {344, 364, 354};
                c.fillPolygon(xPoints1, yPoints1, 3); // left arrow
                int[] xPoints2 = {624, 624, 587};
                int[] yPoints2 = {344, 364, 354};
                c.fillPolygon(xPoints2, yPoints2, 3); // right arrow

                // draws rest of the options
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("Load Game", 430, 434);
                c.drawString("Instructions", 425, 504);
                c.drawString("Quit Game", 430, 574);
            }
            else if (choice == 2) {
                // draws options
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("New Game", 433, 364);

                // highlights "Load Game"
                c.setFont(new Font ("Serif", Font.BOLD, 30));
                c.drawString("Load Game", 430, 434);
                int[] xPoints1 = {378, 378, 415};
                int[] yPoints1 = {414, 434, 424};
                c.fillPolygon(xPoints1, yPoints1, 3); // left arrow
                int[] xPoints2 = {630, 630, 593};
                int[] yPoints2 = {414, 434, 424};
                c.fillPolygon(xPoints2, yPoints2, 3); // right arrow

                // draws rest of options
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("Instructions", 425, 504);
                c.drawString("Quit Game", 430, 574);
            }
            else if (choice == 3) {
                // draws options
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("New Game", 433, 364);
                c.drawString("Load Game", 430, 434);

                // highlights "Instructions"
                c.setFont(new Font ("Serif", Font.BOLD, 30));
                c.drawString("Instructions", 425, 504);
                int[] xPoints1 = {374, 374, 411};
                int[] yPoints1 = {484, 504, 494};
                c.fillPolygon(xPoints1, yPoints1, 3); // left arrow
                int[] xPoints2 = {632, 632, 595};
                int[] yPoints2 = {484, 504, 494};
                c.fillPolygon(xPoints2, yPoints2, 3); // right arrow

                // draws rest of options
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("Quit Game", 430, 574);
            }
            else {
                // draws options
                c.setFont(new Font ("Serif", Font.PLAIN, 30));
                c.drawString("New Game", 433, 364);
                c.drawString("Load Game", 430, 434);
                c.drawString("Instructions", 425, 504);

                // highlights "Quit Game"
                c.setFont(new Font ("Serif", Font.BOLD, 30));
                c.drawString("Quit Game", 430, 574);
                int[] xPoints1 = {378, 378, 415};
                int[] yPoints1 = {554, 574, 564};
                c.fillPolygon(xPoints1, yPoints1, 3); // left arrow
                int[] xPoints2 = {630, 630, 593};
                int[] yPoints2 = {554, 574, 564};
                c.fillPolygon(xPoints2, yPoints2, 3); // right arrow
            }

            // gets input for navigation
            char in = c.getChar();
            if (in == 115) {
                // s key is pressed, highlights the subsequent option
                choice++;
                if (choice == 5) {
                    choice = 1;
                }
            }
            else if (in == 119) {
                // w key is pressed, highlights the previous option
                choice--;
                if (choice == 0) {
                    choice = 4;
                }
            }
            else if (in == 10) {
                // enter key pressed, selection is made
                return;
            }
        }
    }
    public void instructions() {
        int page = 1;
        while (true) {
            char next;
            if (page == 1) {
                // background
                c.setColor(new Color(182,215,168));
                c.fillRect(0, 0, 1024, 728);

                // draws board
                drawBoard(
                    new char[][] {
                            {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
                            {'b', '-', 'b', '-', 'b', '-', 'b', '-'},
                            {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
                            {'e', '-', 'e', '-', 'e', '-', 'e', '-'},
                            {'-', 'e', '-', 'e', '-', 'e', '-', 'e'},
                            {'r', '-', 'r', '-', 'r', '-', 'r', '-'},
                            {'-', 'r', '-', 'r', '-', 'r', '-', 'r'},
                            {'r', '-', 'r', '-', 'r', '-', 'r', '-'},
                    },
                    40,
                    100
                );

                // title
                c.setColor(Color.BLACK);
                c.setFont(new Font("Serif", Font.BOLD, 40));
                c.drawString("Setup", 642, 135);

                // instruction text
                c.setFont(new Font("Serif", Font.PLAIN, 30));
                c.drawString("Checkers is a board game", 642, 200);
                c.drawString("for two players. One", 642, 235);
                c.drawString("player has the red pieces,", 642, 270);
                c.drawString("and the other has the", 642, 305);
                c.drawString("black pieces. At the start", 642, 340);
                c.drawString("of the game, each of the", 642, 375);
                c.drawString("set up as shown on ", 642, 410);
                c.drawString("board.", 642, 445);

                // D key symbol
                c.setColor(Color.WHITE);
                c.fillRoundRect(963, 637, 30, 30, 10, 10); // D

                // D key symbol outline
                c.setColor(Color.BLACK);
                c.drawRoundRect(963, 637, 30, 30, 10, 10); // D

                // instructions for how to switch pages
                c.setFont(new Font("Serif", Font.BOLD, 26));
                c.drawString("Next >    D", 870, 660);
            }
            if (page == 2) {
                // background
                c.setColor(new Color(182,215,168));
                c.fillRect(0, 0, 1024, 728);

                // draws board
                drawBoard(
                        new char[][] {
                                {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
                                {'b', '-', 'b', '-', 'b', '-', 'b', '-'},
                                {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
                                {'e', '-', 'e', '-', 'e', '-', 'e', '-'},
                                {'-', 'r', '-', 'e', '-', 'e', '-', 'e'},
                                {'e', '-', 'r', '-', 'r', '-', 'r', '-'},
                                {'-', 'r', '-', 'r', '-', 'r', '-', 'r'},
                                {'r', '-', 'r', '-', 'r', '-', 'r', '-'},
                        },
                        40,
                        100
                );

                // draws arrow indicating movement of piece
                int[] xPoints1 = {67, 72, 110, 107};
                int[] yPoints1 = {505, 510, 469, 464};
                c.setColor(Color.WHITE);
                c.fillPolygon(xPoints1, yPoints1, 4); // arrow shaft
                int[] xPoints2 = {95, 110, 126};
                int[] yPoints2 = {464, 479, 447};
                c.fillPolygon(xPoints2, yPoints2, 3); // arrow head

                // title
                c.setColor(Color.BLACK);
                c.setFont(new Font("Serif", Font.BOLD, 40));
                c.drawString("Movement", 642, 135);

                // instructions
                c.setFont(new Font("Serif", Font.PLAIN, 30));
                c.drawString("A turn consists of", 642, 200);
                c.drawString("moving one checkers", 642, 235);
                c.drawString("piece. A checker can only", 642, 270);
                c.drawString("move diagonally forwards", 642, 305);
                c.drawString("one space in either", 642, 340);
                c.drawString("direction (diagonally to", 642, 375);
                c.drawString("the left or to the", 642, 410);
                c.drawString("right). A sample move", 642, 445);
                c.drawString("is shown on the board.", 642, 480);

                // D key symbol
                c.setColor(Color.WHITE);
                c.fillRoundRect(963, 637, 30, 30, 10, 10);
                // D key symbol outline
                c.setColor(Color.BLACK);
                c.drawRoundRect(963, 637, 30, 30, 10, 10);

                // instructions for how to go to next page
                c.setFont(new Font("Serif", Font.BOLD, 26));
                c.drawString("Next >    D", 870, 660);

                // A key symbol
                c.setColor(Color.WHITE);
                c.fillRoundRect(692, 637, 30, 30, 10, 10);

                // A key symbol outline
                c.setColor(Color.BLACK);
                c.drawRoundRect(692, 637, 30, 30, 10, 10);

                // instructions for how to go to previous page
                c.drawString("A    < Prev", 700, 660);
            }
            if (page == 3) {
                // background
                c.setColor(new Color(182,215,168));
                c.fillRect(0, 0, 1024, 728);

                // draws board
                drawBoard(
                        new char[][] {
                                {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
                                {'b', '-', 'b', '-', 'b', '-', 'b', '-'},
                                {'-', 'b', '-', 'e', '-', 'b', '-', 'b'},
                                {'e', '-', 'b', '-', 'e', '-', 'e', '-'},
                                {'-', 'r', '-', 'e', '-', 'e', '-', 'e'},
                                {'e', '-', 'r', '-', 'r', '-', 'r', '-'},
                                {'-', 'r', '-', 'r', '-', 'r', '-', 'r'},
                                {'r', '-', 'r', '-', 'r', '-', 'r', '-'},
                        },
                        40,
                        100
                );

                // draws arrows indicating piece movement
                c.setColor(Color.WHITE);
                int[] xPoints1 = {160, 165, 256, 251};
                int[] yPoints1 = {405, 410, 320, 315};
                c.fillPolygon(xPoints1, yPoints1, 4); // arrow shaft
                int[] xPoints2 = {242, 278, 262};
                int[] yPoints2 = {308, 293, 325};
                c.fillPolygon(xPoints2, yPoints2, 3); // arrowhead

                // title
                c.setColor(Color.BLACK);
                c.setFont(new Font("Serif", Font.BOLD, 40));
                c.drawString("Capture", 642, 130);

                // instructions
                c.setFont(new Font("Serif", Font.PLAIN, 30));
                c.drawString("You can capture", 642, 200);
                c.drawString("your opponent’s pieces by", 642, 235);
                c.drawString("jumping over them. In", 642, 270);
                c.drawString("this example, the red", 642, 305);
                c.drawString("piece can jump over the", 642, 340);
                c.drawString("black one, thereby", 642, 375);
                c.drawString("capturing the black piece.", 642, 410);
                c.drawString("It is then removed from", 642, 445);
                c.drawString("the board. The goal of", 642, 480);
                c.drawString("the game is to capture all", 642, 515);
                c.drawString("of your opponent’s pieces.", 642, 550);

                // D key symbol
                c.setColor(Color.WHITE);
                c.fillRoundRect(963, 637, 30, 30, 10, 10);

                // D key symbol outline
                c.setColor(Color.BLACK);
                c.drawRoundRect(963, 637, 30, 30, 10, 10);

                // instructions for how to move to the next page
                c.setFont(new Font("Serif", Font.BOLD, 26));
                c.drawString("Next >    D", 870, 660);

                // A key symbol
                c.setColor(Color.WHITE);
                c.fillRoundRect(692, 637, 30, 30, 10, 10);

                // A key symbol outline
                c.setColor(Color.BLACK);
                c.drawRoundRect(692, 637, 30, 30, 10, 10);

                // instructions for how to move to the next page
                c.drawString("A    < Prev", 700, 660);
            }
            if (page == 4) {
                // background
                c.setColor(new Color(182,215,168));
                c.fillRect(0, 0, 1024, 728);

                // draws board
                drawBoard(
                        new char[][] {
                                {'-', 'e', '-', 'e', '-', 'R', '-', 'e'},
                                {'b', '-', 'e', '-', 'r', '-', 'e', '-'},
                                {'-', 'e', '-', 'e', '-', 'e', '-', 'e'},
                                {'r', '-', 'b', '-', 'e', '-', 'b', '-'},
                                {'-', 'e', '-', 'b', '-', 'b', '-', 'b'},
                                {'e', '-', 'r', '-', 'r', '-', 'e', '-'},
                                {'-', 'r', '-', 'b', '-', 'e', '-', 'e'},
                                {'e', '-', 'e', '-', 'e', '-', 'e', '-'},
                        },
                        40,
                        100
                );

                // draws arrow to indicate piece movement
                c.setColor(Color.WHITE);
                int[] xPoints2 = {440, 445, 475, 470};
                int[] yPoints2 = {160, 155, 190, 195};
                c.fillPolygon(xPoints2, yPoints2, 4); // arrow shaft
                int[] xPoints3 = {455, 470, 485};
                int[] yPoints3 = {195, 175, 205};
                c.fillPolygon(xPoints3, yPoints3, 3); // arrow head

                // title
                c.setColor(Color.BLACK);
                c.setFont(new Font("Serif", Font.BOLD, 40));
                c.drawString("King", 642, 130);

                // instructions
                c.setFont(new Font("Serif", Font.PLAIN, 30));
                c.drawString("If your piece reaches the", 642, 200);
                c.drawString("last row, it becomes a", 642, 235);
                c.drawString("king. Kings can move or", 642, 270);
                c.drawString("capture one space", 642, 305);
                c.drawString("diagonally in any", 642, 340);
                c.drawString("direction. They are not", 642, 375);
                c.drawString("limited to moving", 642, 410);
                c.drawString("forwards only.", 642, 445);

                // D key symbol
                c.setColor(Color.WHITE);
                c.fillRoundRect(963, 637, 30, 30, 10, 10);

                // D key outline
                c.setColor(Color.BLACK);
                c.drawRoundRect(963, 637, 30, 30, 10, 10);
                c.setFont(new Font("Serif", Font.BOLD, 26));

                // instructions for how to move to next page
                c.drawString("Return >    D", 844, 660);

                // A key symbol
                c.setColor(Color.WHITE);
                c.fillRoundRect(692, 637, 30, 30, 10, 10);

                // A key outline
                c.setColor(Color.BLACK);
                c.drawRoundRect(692, 637, 30, 30, 10, 10);

                // instructions for how to move to previous page
                c.drawString("A    < Prev", 700, 660);
            }

            // getting keyboard input
            next = c.getChar();
            if (next == 100) {
                // D key pressed
                c.clear();
                page++; // go to next page
                if (page == 5) {
                    choice = 1;
                    return;
                }
            }
            if (next == 97) {
                // A key pressed
                if (page > 1) {
                    page--; // go to previous page
                    c.clear();
                }
            }
        }

    }
    public void goodbye() {
        // background
        c.setColor(new Color(182,215,168));
        c.fillRect(0, 0, 1024, 728);
        c.setColor(Color.BLACK);

        // thank you message
        c.setFont(new Font ("Serif", Font.BOLD, 75));
        c.drawString("Thanks for playing!", 190, 220);
        c.setFont(new Font ("Serif", Font.PLAIN, 35));
        c.drawString("This program was made by Ethan Diep and Glen Lin,", 150, 355);
        c.drawString("submitted on January 18, 2022 as a culminating\n", 180, 400);
        c.drawString("assignment for ICS3U.", 320, 445);

        // checker drawing at the bottom
        drawChecker(210, 555, true);
        drawChecker(210, 525, false);
        drawChecker(360, 585, true);
        drawChecker(285, 655, false);
        drawChecker(585, 625, false);
        drawChecker(665, 565, true);
        c.setFont(new Font ("Serif", Font.BOLD, 30));
        c.setColor(Color.BLACK);

        // exit message
        c.drawString("Press any key to exit.", 370, 550);
        char quit = c.getChar();
        c.close();
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
        // draws a checker as it appears from the side

        // changing checker colour
        if (isRed) {
            c.setColor(new Color(224, 102, 102)); // light red
        } else {
            c.setColor(new Color(102,102,102)); // light grey
        }

        c.fillRect(x, y + 20, 111, 20); // middle part of checker

        // setting the colour again to prevent colour changing during animation
        if (isRed) {
            c.setColor(new Color(224, 102, 102)); // light red
        } else {
            c.setColor(new Color(102,102,102)); // light grey
        }

        c.fillOval(x, y + 22, 111, 37); // bottom part of checker

        // setting the colour
        if (isRed) {
            c.setColor(new Color(204,0,0)); // dark red
        } else {
            c.setColor(new Color(67,67,67)); // dark grey
        }

        c.fillOval(x, y, 111, 37); // top part of oval
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

    public static void drawTopChecker(int x, int y, int diameter, int borderThickness, boolean isRed, boolean isKing) {
        // setting border colour
        if (isRed) {
            c.setColor(new Color(109, 0, 0));
        } else {
            c.setColor(Color.BLACK);
        }
        // drawing bottom layer of checkers that acts as the border
        c.fillOval(x, y, diameter, diameter);

        // setting the piece's colour
        if (isRed) {
            c.setColor(new Color(204, 0, 0));
        } else {
            c.setColor(new Color(67,67,67));
        }
        // drawing the main part of the piece (smaller to account for border)
        c.fillOval(x + borderThickness, y + borderThickness, diameter - borderThickness*2, diameter - borderThickness*2);

        int crownOffsetX = x + borderThickness + 7;
        int crownOffsetY = y + borderThickness + 9;

        if (isKing) {
            // draws crown
            int[] xPoints = {crownOffsetX, crownOffsetX + 5, crownOffsetX + 11, crownOffsetX + 17, crownOffsetX + 23, crownOffsetX + 23, crownOffsetX};
            int[] yPoints = {crownOffsetY + 3, crownOffsetY + 7, crownOffsetY, crownOffsetY + 7, crownOffsetY + 3, crownOffsetY + 14, crownOffsetY + 14, crownOffsetY + 14};
            c.setColor(new Color(246,178,107)); // yellow for crown
            c.fillPolygon(xPoints, yPoints, 7);
        }
    }

    public static void drawBoard(char[][] boardArr, int x, int y) {
        // method to draw a checkers board from a given array and coordinates

        c.setColor(Color.BLACK);
        c.fillRoundRect(x, y, 570, 570, 3, 3); // board background

        Color lightBrown = new Color(230,202,175); // light brown squares
        Color darkBrown = new Color(145,95,47); // dark brown squares

        for (int row = 0; row < 8; row ++) {
            for (int col = 0; col < 8; col ++) {
                // setting square colour
                if (row % 2 == 0) {
                    if (col % 2 == 0) {
                        c.setColor(lightBrown);
                    } else {
                        c.setColor(darkBrown);
                    }
                } else {
                    if (col % 2 == 0) {
                        c.setColor(darkBrown);
                    } else {
                        c.setColor(lightBrown);
                    }
                }

                // drawing square
                c.fillRect(5 + x + 70 * col, 5 + y + 70 * row, 70, 70);

                // drawing piece on square
                switch (boardArr[row][col]) {
                    case 'r': // red plain checker
                        drawTopChecker(17 + x + 70 * col, 17 + y + 70 * row, 44, 4, true, false);
                        break;
                    case 'b': // black plain checker
                        drawTopChecker(17 + x + 70 * col, 17 + y + 70 * row, 44, 4, false, false);
                        break;
                    case 'R': // red king
                        drawTopChecker(17 + x + 70 * col, 17 + y + 70 * row, 44, 4, true, true);
                        break;
                    case 'B': // black king
                        drawTopChecker(17 + x + 70 * col, 17 + y + 70 * row, 44, 4, false, true);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
