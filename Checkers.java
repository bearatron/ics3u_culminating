// Names: Ethan Diep and Glen Lin
// Date: January 13, 2023
// Teacher: Ms. Basaraba
// Description: This program makes a checkers game in the Console window

import java.awt.*;
import java.io.*;
import hsa.Console;
import hsa.Message;

public class Checkers {
    static Console c;
    static int choice = 1, turnNumber = 1;
    static char [][] board = new char[8][8];
    static String playerOne, playerTwo;
    static boolean playerOnesTurn = true, fileLoaded = false;
    public static void main(String[] args) {
        Checkers g = new Checkers();

//        g.loadFile();
//
//        try {
//            Thread.sleep(10000);
//        } catch (Exception e) {}
//
//        g.splashScreen();
        while (true) {
            g.mainMenu();
            if (choice == 1) {
                c.clear();
                if (fileLoaded) {
                    g.game();
                } else {
                    g.gameSetup();
                }
            }
            else if (choice == 2) {
                c.clear();
                g.loadFile();
            }
            else if (choice == 3) {
                c.clear();
                g.instructions();
            }
            else {
                c.clear();
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
        choice = 1;

        if (fileLoaded) {
            return;
        }

        // title
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

    public void gameSetup() {
        // initializing default game requirements

        playerOne = getName(true); // getting player one's name
        playerTwo = getName(false); // getting player two's name

        // setting up the board
        board = new char[][] {
                {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
                {'b', '-', 'b', '-', 'b', '-', 'b', '-'},
                {'-', 'b', '-', 'b', '-', 'b', '-', 'b'},
                {'e', '-', 'e', '-', 'e', '-', 'e', '-'},
                {'-', 'e', '-', 'e', '-', 'e', '-', 'e'},
                {'r', '-', 'r', '-', 'r', '-', 'r', '-'},
                {'-', 'r', '-', 'r', '-', 'r', '-', 'r'},
                {'r', '-', 'r', '-', 'r', '-', 'r', '-'},
        };

        turnNumber = 1; // resetting turn number
        playerOnesTurn = true; // resetting player turn indicator

        try {
            // creating an object for the game file
            File gameFile = new File("gameState.txt");

            gameFile.createNewFile(); // creates new game file

            try {
                FileWriter fw = new FileWriter(gameFile);
                PrintWriter pw = new PrintWriter(fw);

                // adds board to file
                for (int i = 0; i < board.length; i ++) {
                    for (int j = 0; j < board[i].length; j ++) {
                        pw.print(board[i][j]);
                    }
                    pw.println();
                }

                // adds player names to file
                pw.println(playerOne);
                pw.println(playerTwo);

                // adds number of moves to file
                pw.println(turnNumber);

                // adds if it's player one's turn to the file
                pw.println(playerOnesTurn);

                // closes the file
                pw.close();
            } catch (Exception e) {
                new Message(e.getMessage()); // displays error message
                mainMenu(); // brings user back to main menu
            }
        } catch (Exception e) {
            new Message(e.getMessage()); // displays error message
            mainMenu(); // brings user back to main menu
        }

        game(); // proceeding to the game
    }

    public String getName(boolean redPlayer) {
        String name = ""; // variable to store the user's name

        // background
        c.setColor(new Color(182,215,168));
        c.fillRect(0, 0, 1024, 728);

        // title
        c.setColor(Color.BLACK);
        c.setFont(new Font ("Serif", Font.BOLD, 60));
        c.drawString("ENTER YOUR NAME", 225, 180);

        // instructions
        c.setFont(new Font ("Serif", Font.PLAIN, 30));
        c.drawString("Player   , please enter your name below. Your name must be", 140, 380);

        if (redPlayer) {
            // drawing red checkers
            for (int i = 300; i <= 600; i += 150) {
                drawChecker(i, 270, true);
            }

            // displaying different text
            c.setColor(Color.BLACK);
            c.drawString("1", 223, 380);
            c.drawString("between 1 and 20 characters long. You will play as red.", 165, 420);
        } else {
            // drawing black checkers
            for (int i = 300; i <= 600; i += 150) {
                drawChecker(i, 270, false);
            }
            // displaying different text
            c.setColor(Color.BLACK);
            c.drawString("2", 223, 380);
            c.drawString("between 1 and 20 characters long. You will play as black.", 155, 420);
        }

        // drawing text box
        c.setColor(new Color(0, 0, 0));
        c.fillRoundRect(146, 471, 732, 83, 3, 3);
        c.setColor(new Color(255, 255, 255));
        c.fillRect(150, 475, 724, 75);

        // variable to store the most recent letter the user typed
        char input = c.getChar();

        while (true) {
            // redrawing text box
            c.setColor(new Color(0, 0, 0));
            c.fillRoundRect(146, 471, 732, 83, 3, 3);
            c.setColor(new Color(255, 255, 255));
            c.fillRect(150, 475, 724, 75);

            // add the input to name if the user presses an alphanumeric key
            if (input >= 32 && input <= 126) {
                name += input;
            }

            // if the user presses backspace, delete one letter from the name
            if (input == 8 && name.length() > 0) {
                name = name.substring(0, name.length() - 1);
            }

            // user presses enter
            if (input == 10) {
                if (name.length() >= 1 && name.length() <= 20) {
                    return name; // returns name
                } else {
                    // erases previous error message
                    c.setColor(new Color(182, 215, 168));
                    c.fillRect(0, 555, 1024, 60);

                    // displays error message
                    c.setColor(new Color(224, 19, 19));
                    c.setFont(new Font("Serif", Font.PLAIN, 45));
                    c.drawString("Name must be between 1 and 20 characters", 125, 610);
                }
            }

            // drawing what the user has typed so far to the screen
            c.setFont(new Font ("MonoSpaced", Font.PLAIN, 60));
            c.setColor(new Color(0, 0, 0));
            if (name.length() <= 19) {
                c.drawString(name, 160, 530);
            }
            else {
                // scrolls the text if it overflows as the user types
                c.drawString(name, 145 - 36 * (name.length() - 20), 530);
            }

            // covers the overflow text
            c.setColor(new Color(182,215,168));
            c.fillRect(0, 471, 146, 83);

            input = c.getChar(); // gets next keyboard input
        }
    }

    public void game() {
        while (true) {
            turn();

            if (!playerOnesTurn) {
                // increment turn number if it's black's turn
                turnNumber++;
            }

            playerOnesTurn = !playerOnesTurn;

            // write new position to file
            try {
                // creating an object for the game file
                File gameFile = new File("gameState.txt");

                try {
                    FileWriter fw = new FileWriter(gameFile);
                    PrintWriter pw = new PrintWriter(fw);

                    // adds board to file
                    for (int i = 0; i < board.length; i ++) {
                        for (int j = 0; j < board[i].length; j ++) {
                            pw.print(board[i][j]);
                        }
                        pw.println();
                    }

                    // adds player names to file
                    pw.println(playerOne);
                    pw.println(playerTwo);

                    // adds number of moves to file
                    pw.println(turnNumber);

                    // adds if it's player one's turn to the file
                    pw.println(playerOnesTurn);

                    // closes the file
                    pw.close();
                } catch (Exception e) {
                    new Message(e.getMessage()); // displays error message
                    mainMenu(); // brings user back to main menu
                }
            } catch (Exception e) {
                new Message(e.getMessage()); // displays error message
                mainMenu(); // brings user back to main menu
            }
        }
    }

    public void turn() {
        fileLoaded = false; // reset file loaded variable

        // draws the background and board
        c.setColor(new Color(182,215,168));
        c.fillRect(0, 0, 1024, 728);
        drawBoard(board, 40, 115);

        // message that says whose turn it is
        c.setColor(Color.BLACK);
        c.setFont(new Font("Monospaced", Font.BOLD, 40));

        // drawing centered message
        if (playerOnesTurn) {
            c.drawString(playerOne, 512 - (7 + playerOne.length()) / 2 * 25, 90);
            c.drawString("'s turn", 512 - (7 + playerOne.length()) / 2 * 25 + playerOne.length() * 25, 90);
            drawTopChecker(665, 120, 44, 4, true, false);
        } else {
            c.drawString(playerTwo, 512 - (7 + playerTwo.length()) / 2 * 25, 90);
            c.drawString("'s turn", 512 - (7 + playerTwo.length()) / 2 * 25 + playerTwo.length() * 25, 90);
            drawTopChecker(665, 120, 44, 4, false, false);
        }

        // displaying the turn number
        c.setColor(Color.BLACK);
        c.setFont(new Font("Monospaced", Font.BOLD, 30));
        c.drawString("Turn", 725, 150);
        c.drawString(String.valueOf(turnNumber), 810, 150);

        // instructions
        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.PLAIN, 30));
        c.drawString("Use", 685, 350);

        // W key
        c.setColor(Color.WHITE);
        c.fillRoundRect(815, 280, 30, 30, 10, 10);
        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.BOLD, 24));
        c.drawRoundRect(815, 280, 30, 30, 10, 10);
        c.drawString("W", 819,305);

        // A key
        c.setColor(Color.WHITE);
        c.fillRoundRect(775, 325, 30, 30, 10, 10);
        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.BOLD, 24));
        c.drawRoundRect(775, 325, 30, 30, 10, 10);
        c.drawString("A", 781,350);

        // S key
        c.setColor(Color.WHITE);
        c.fillRoundRect(815, 325, 30, 30, 10, 10);
        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.BOLD, 24));
        c.drawRoundRect(815, 325, 30, 30, 10, 10);
        c.drawString("S", 822,350);

        // D key
        c.setColor(Color.WHITE);
        c.fillRoundRect(855, 325, 30, 30, 10, 10);
        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.BOLD, 24));
        c.drawRoundRect(855, 325, 30, 30, 10, 10);
        c.drawString("D", 860,350);

        // instructions continued
        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.PLAIN, 30));
        c.drawString("to move the cursor", 675, 417);
        c.drawString("Press                 to select", 655, 520);

        // enter key
        c.setColor(Color.WHITE);
        c.fillRoundRect(730, 495, 100, 30, 10, 10); // enter
        c.setColor(Color.BLACK);
        c.drawRoundRect(730, 495, 100, 30, 10, 10); // enter

        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.BOLD, 24));
        c.drawString("ENTER", 738, 520);

        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.BOLD, 30));
        c.drawString("Choose a piece to move", 645, 650);

        int[] selection;
        int pieceRow, pieceCol, rowTo, colTo;

        // selecting piece
        while (true) {
            selection = squareSelection(7, 0);
            pieceRow = selection[0];
            pieceCol = selection[1];

            if (playerOnesTurn) {
                if (board[pieceRow][pieceCol] == 'r' || board[pieceRow][pieceCol] == 'R') {
                    break;
                } else {
                    new Message("Invalid choice, please select a square with a red checker on it");
                }
            } else {
                if (board[pieceRow][pieceCol] == 'b' || board[pieceRow][pieceCol] == 'B') {
                    break;
                } else {
                    new Message("Invalid choice, please select a square with a black checker on it");
                }
            }
        }

        // selecting square to move to
        while (true) {
            selection = squareSelection(7, 0, pieceRow, pieceCol);
            rowTo = selection[0];
            colTo = selection[1];

            if (validMove(pieceRow, pieceCol, rowTo, colTo)) {
                new Message("Valid move");
                break;
            } else {
                new Message("Invalid move");
            }
        }

        // updating board
        if (playerOnesTurn) {
            // red's turn
            if (Math.abs(rowTo - pieceRow) == 2) {
                // capturing piece
                if (rowTo - pieceRow == -2) {
                    // capturing forwards
                    if (colTo - pieceCol < 0) {
                        // capturing left
                        board[rowTo + 1][colTo + 1] = 'e';
                    } else {
                        // capturing right
                        board[rowTo + 1][colTo - 1] = 'e';
                    }
                } else {
                    // capturing backwards
                    if (colTo - pieceCol < 0) {
                        // capturing left
                        board[rowTo - 1][colTo + 1] = 'e';
                    } else {
                        // capturing right
                        board[rowTo - 1][colTo - 1] = 'e';
                    }
                }
            }

            // moves piece forward
            board[rowTo][colTo] = board[pieceRow][pieceCol];
            board[pieceRow][pieceCol] = 'e';

        } else {
            // black's turn
            if (Math.abs(rowTo - pieceRow) == 2) {
                // capturing piece
                if (rowTo - pieceRow == 2) {
                    // capturing forwards
                    if (colTo - pieceCol < 0) {
                        // capturing left
                        board[rowTo - 1][colTo + 1] = 'e';
                    } else {
                        // capturing right
                        board[rowTo - 1][colTo - 1] = 'e';
                    }
                } else {
                    // capturing backwards
                    if (colTo - pieceCol < 0) {
                        // capturing left
                        board[rowTo + 1][colTo + 1] = 'e';
                    } else {
                        // capturing right
                        board[rowTo + 1][colTo - 1] = 'e';
                    }
                }
            }

            // moves piece forward
            board[rowTo][colTo] = board[pieceRow][pieceCol];
            board[pieceRow][pieceCol] = 'e';
        }

    }

    public boolean validMove(int rowFrom, int colFrom, int rowTo, int colTo) {
        char piece = board[rowFrom][colFrom];

        if (playerOnesTurn && (piece == 'r' || piece == 'R')) {
            // red's turn
            if (Math.abs(rowTo - rowFrom) == 1) {
                // moving one forwards or backwards
                if (rowTo - rowFrom < 0) {
                    // moving forward one square
                    if (Math.abs(colTo - colFrom) == 1) {
                        // makes sure the piece is moving on a diagonal
                        if (board[rowTo][colTo] == 'e') {
                            // square is empty
                            return true;
                        }
                    }
                } else {
                    // moving backward one square
                    if (piece == 'R') {
                        if (Math.abs(colTo - colFrom) == 1) {
                            // makes sure the piece is moving on a diagonal
                            if (board[rowTo][colTo] == 'e') {
                                // square is empty
                                return true;
                            }
                        }
                    }
                }
            } else if (Math.abs(rowTo - rowFrom) == 2) {
                // capturing piece

                if (rowTo - rowFrom == -2 && Math.abs(colTo - colFrom) == 2) {
                    // capturing forwards
                    if (board[rowTo][colTo] == 'e') {
                        if (colTo - colFrom < 0) {
                            // capturing left
                            if (board[rowTo + 1][colTo + 1] == 'b' || board[rowTo + 1][colTo + 1] == 'B') {
                                return true;
                            }
                        } else {
                            // capturing right
                            if (board[rowTo + 1][colTo - 1] == 'b' || board[rowTo + 1][colTo - 1] == 'B') {
                                return true;
                            }
                        }
                    }
                } else if (rowTo - rowFrom == 2 && Math.abs(colTo - colFrom) == 2) {
                    // capturing backwards (only for kings)
                    if (piece == 'R' && board[rowTo][colTo] == 'e') {
                        if (colTo - colFrom < 0) {
                            // capturing left
                            if (board[rowTo - 1][colTo + 1] == 'b' || board[rowTo - 1][colTo + 1] == 'B') {
                                return true;
                            }
                        } else {
                            // capturing right
                            if (board[rowTo - 1][colTo - 1] == 'b' || board[rowTo - 1][colTo - 1] == 'B') {
                                return true;
                            }
                        }
                    }
                }

            }
        } else if (!playerOnesTurn && (piece == 'b' || piece == 'B')) {
            // black's turn
            if (Math.abs(rowTo - rowFrom) == 1) {
                // moving one forwards or backwards
                if (rowTo - rowFrom > 0) {
                    // moving forward one square
                    if (Math.abs(colTo - colFrom) == 1) {
                        // makes sure the piece is moving on a diagonal
                        if (board[rowTo][colTo] == 'e') {
                            // square is empty
                            return true;
                        }
                    }
                } else {
                    // moving backward one square
                    if (piece == 'B') {
                        if (Math.abs(colTo - colFrom) == 1) {
                            // makes sure the piece is moving on a diagonal
                            if (board[rowTo][colTo] == 'e') {
                                // square is empty
                                return true;
                            }
                        }
                    }
                }
            } else if (Math.abs(rowTo - rowFrom) == 2) {
                // capturing piece

                if (rowTo - rowFrom == 2 && Math.abs(colTo - colFrom) == 2) {
                    // capturing forwards
                    if (board[rowTo][colTo] == 'e') {
                        if (colTo - colFrom < 0) {
                            // capturing left
                            if (board[rowTo - 1][colTo + 1] == 'r' || board[rowTo - 1][colTo + 1] == 'R') {
                                return true;
                            }
                        } else {
                            // capturing right
                            if (board[rowTo - 1][colTo - 1] == 'r' || board[rowTo - 1][colTo - 1] == 'R') {
                                return true;
                            }
                        }
                    }
                } else if (rowTo - rowFrom == -2 && Math.abs(colTo - colFrom) == 2) {
                    // capturing backwards (only for kings)
                    if (piece == 'B' && board[rowTo][colTo] == 'e') {
                        if (colTo - colFrom < 0) {
                            // capturing left
                            if (board[rowTo + 1][colTo + 1] == 'r' || board[rowTo + 1][colTo + 1] == 'R') {
                                return true;
                            }
                        } else {
                            // capturing right
                            if (board[rowTo + 1][colTo - 1] == 'r' || board[rowTo + 1][colTo - 1] == 'R') {
                                return true;
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

    public int[] squareSelection(int startingRow, int startingCol) {
        int row = startingRow;
        int col = startingCol;
        char input = 'a';

        while (true) {
            // draws board
            drawBoard(board, 40, 115);

            // square border
            c.setColor(Color.WHITE);
            c.fillRect(5 + 40 + 70 * col, 5 + 115 + 70 * row, 70, 70);

            Color lightBrown = new Color(230, 202, 175); // light brown squares
            Color darkBrown = new Color(145, 95, 47); // dark brown squares

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
            c.fillRect(4 + 5 + 40 + 70 * col, 4 + 5 + 115 + 70 * row, 62, 62);

            // drawing piece on square
            switch (board[row][col]) {
                case 'r': // red plain checker
                    drawTopChecker(17 + 40 + 70 * col, 17 + 115 + 70 * row, 44, 4, true, false);
                    break;
                case 'b': // black plain checker
                    drawTopChecker(17 + 40 + 70 * col, 17 + 115 + 70 * row, 44, 4, false, false);
                    break;
                case 'R': // red king
                    drawTopChecker(17 + 40 + 70 * col, 17 + 115 + 70 * row, 44, 4, true, true);
                    break;
                case 'B': // black king
                    drawTopChecker(17 + 40 + 70 * col, 17 + 115 + 70 * row, 44, 4, false, true);
                    break;
                default:
                    break;
            }

            input = c.getChar();

            if (input == 'w') {
                if (row != 0){
                    row --;
                }
            } else if (input == 's') {
                if (row != 7) {
                    row ++;
                }
            } else if (input == 'a') {
                if (col != 0) {
                    col --;
                }
            } else if (input == 'd'){
                if (col != 7) {
                    col ++;
                }
            } else if (input == 10) {
                // enter key pressed
                break;
            }

        }

        return new int[] {row, col}; // placeholder
    }

    public int[] squareSelection(int startingRow, int startingCol, int selectedRow, int selectedCol) {
        int row = startingRow;
        int col = startingCol;
        char input = 'a';

        while (true) {
            // draws board
            drawBoard(board, 40, 115);

            // square border
            c.setColor(Color.WHITE);
            c.fillRect(5 + 40 + 70 * selectedCol, 5 + 115 + 70 * selectedRow, 70, 70);
            c.fillRect(5 + 40 + 70 * col, 5 + 115 + 70 * row, 70, 70);

            Color lightBrown = new Color(230, 202, 175); // light brown squares
            Color darkBrown = new Color(145, 95, 47); // dark brown squares

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

            // drawing currently highlighted square
            c.fillRect(4 + 5 + 40 + 70 * col, 4 + 5 + 115 + 70 * row, 62, 62);


            // setting square colour
            if (selectedRow % 2 == 0) {
                if (selectedCol % 2 == 0) {
                    c.setColor(lightBrown);
                } else {
                    c.setColor(darkBrown);
                }
            } else {
                if (selectedCol % 2 == 0) {
                    c.setColor(darkBrown);
                } else {
                    c.setColor(lightBrown);
                }
            }

            // drawing already selected square
            c.fillRect(4 + 5 + 40 + 70 * selectedCol, 4 + 5 + 115 + 70 * selectedRow, 62, 62);

            // drawing highlighted piece on square
            switch (board[row][col]) {
                case 'r': // red plain checker
                    drawTopChecker(17 + 40 + 70 * col, 17 + 115 + 70 * row, 44, 4, true, false);
                    break;
                case 'b': // black plain checker
                    drawTopChecker(17 + 40 + 70 * col, 17 + 115 + 70 * row, 44, 4, false, false);
                    break;
                case 'R': // red king
                    drawTopChecker(17 + 40 + 70 * col, 17 + 115 + 70 * row, 44, 4, true, true);
                    break;
                case 'B': // black king
                    drawTopChecker(17 + 40 + 70 * col, 17 + 115 + 70 * row, 44, 4, false, true);
                    break;
                default:
                    break;
            }

            // drawing piece on selected square
            switch (board[selectedRow][selectedCol]) {
                case 'r': // red plain checker
                    drawTopChecker(17 + 40 + 70 * selectedCol, 17 + 115 + 70 * selectedRow, 44, 4, true, false);
                    break;
                case 'b': // black plain checker
                    drawTopChecker(17 + 40 + 70 * selectedCol, 17 + 115 + 70 * selectedRow, 44, 4, false, false);
                    break;
                case 'R': // red king
                    drawTopChecker(17 + 40 + 70 * selectedCol, 17 + 115 + 70 * selectedRow, 44, 4, true, true);
                    break;
                case 'B': // black king
                    drawTopChecker(17 + 40 + 70 * selectedCol, 17 + 115 + 70 * selectedRow, 44, 4, false, true);
                    break;
                default:
                    break;
            }

            input = c.getChar();

            if (input == 'w') {
                if (row != 0){
                    row --;
                }
            } else if (input == 's') {
                if (row != 7) {
                    row ++;
                }
            } else if (input == 'a') {
                if (col != 0) {
                    col --;
                }
            } else if (input == 'd'){
                if (col != 7) {
                    col ++;
                }
            } else if (input == 10) {
                // enter key pressed
                break;
            }
        }

        return new int[] {row, col}; // placeholder
    }

    public void updateGameFile() {

    }

    public void animateMove() {

    }

    public char evaluatePosition() {
        return 'w'; // placeholder
    }

    public void loadFile() {
        String fileName = ""; // variable to store the file name

        // background
        c.setColor(new Color(182,215,168));
        c.fillRect(0, 0, 1024, 728);

        // title
        c.setColor(Color.BLACK);
        c.setFont(new Font ("Serif", Font.BOLD, 60));
        c.drawString("LOAD A FILE", 320, 120);

        // instructions
        c.setFont(new Font ("Serif", Font.PLAIN, 30));
        c.drawString("Load a game file to continue where you left off. Make sure the file is", 110, 200);
        c.drawString("in the same folder as this program and is a .txt file, or else it will", 132, 240);
        c.drawString("not work. (The standard file is called “gameState.txt”.)", 200, 280);
        c.drawString("or type “quit“ to go back to main menu", 280, 650);
        c.setFont(new Font("Serif", Font.BOLD, 30));
        c.drawString("Enter the file’s name (including “.txt”)", 280, 350);

        // drawing text box
        c.setColor(new Color(0, 0, 0));
        c.fillRoundRect(146, 421, 732, 83, 3, 3);
        c.setColor(new Color(255, 255, 255));
        c.fillRect(150, 425, 724, 75);

        // variable to store the most recent letter the user typed
        char input = c.getChar();

        while (true) {
            // redrawing text box
            c.setColor(new Color(0, 0, 0));
            c.fillRoundRect(146, 421, 732, 83, 3, 3);
            c.setColor(new Color(255, 255, 255));
            c.fillRect(150, 425, 724, 75);

            // add the input to fileName if the user presses an alphanumeric key
            if (input >= 32 && input <= 126) {
                fileName += input;
            }

            // if the user presses backspace, delete one letter from the name
            if (input == 8 && fileName.length() > 0) {
                fileName = fileName.substring(0, fileName.length() - 1);
            }

            // user presses enter
            if (input == 10) {
                try {
                    BufferedReader sc = new BufferedReader(new FileReader(fileName));

                    // fill the board variable with the information stored in the file
                    for (int i = 0; i < 8; i++) {
                        String line = sc.readLine();
                        for (int j = 0; j < 8; j++) {
                            board[i][j] = line.charAt(j);
                        }
                    }

                    // fill in the players' names with the information stored in the file
                    playerOne = sc.readLine();
                    playerTwo = sc.readLine();

                    // fill in the number of moves made with the information stored in the file
                    turnNumber = Integer.parseInt(sc.readLine());

                    // fill in whose turn it is with the information stored in the file
                    playerOnesTurn = Boolean.parseBoolean(sc.readLine());

                    fileLoaded = true;
                    return;
                }
                catch (FileNotFoundException e) {
                    // erases previous error message
                    c.setColor(new Color(182,215,168));
                    c.fillRect(0, 504, 1024, 60);
                    c.setColor(new Color(224, 19, 19));

                    // displays error message
                    c.setFont(new Font ("Serif", Font.PLAIN, 45));
                    c.drawString("File was not found", 342, 560);
                }
                catch (IOException e) {
                    // erases previous error message
                    c.setColor(new Color(182,215,168));
                    c.fillRect(0, 504, 1024, 60);
                    c.setColor(new Color(224, 19, 19));

                    // displays error message
                    c.setFont(new Font ("Serif", Font.PLAIN, 45));
                    c.drawString("File is incorrectly formatted, or does not exist", 115, 560);
                }
                catch (NullPointerException e) {
                    // erases previous error message
                    c.setColor(new Color(182,215,168));
                    c.fillRect(0, 504, 1024, 60);
                    c.setColor(new Color(224, 19, 19));

                    // displays error message
                    c.setFont(new Font ("Serif", Font.PLAIN, 45));
                    c.drawString("File is empty or does not exist", 252, 560);
                }

                // leave load file window
                if (fileName.equals("quit")) {
                    return;
                }
            }

            // drawing what the user has typed so far to the screen
            c.setFont(new Font ("MonoSpaced", Font.PLAIN, 60));
            c.setColor(new Color(0, 0, 0));
            if (fileName.length() <= 19) {
                c.drawString(fileName, 160, 480);
            }
            else {
                // scrolls the text if it overflows as the user types
                c.drawString(fileName, 145 - 36 * (fileName.length() - 20), 480);
            }

            // covers the overflow text
            c.setColor(new Color(182,215,168));
            c.fillRect(0, 421, 146, 83);

            input = c.getChar(); // gets next keyboard input
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
                int[] xPoints1 = {63, 68, 106, 103};
                int[] yPoints1 = {505, 510, 469, 464};
                c.setColor(Color.WHITE);
                c.fillPolygon(xPoints1, yPoints1, 4); // arrow shaft
                int[] xPoints2 = {91, 106, 122};
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
                int[] xPoints2 = {442, 447, 482, 477};
                int[] yPoints2 = {160, 155, 190, 195};
                c.fillPolygon(xPoints2, yPoints2, 4); // arrow shaft
                int[] xPoints3 = {460, 475, 490};
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
