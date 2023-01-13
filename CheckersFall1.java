// Names: Ethan Diep and Glen Lin
// Date: January 13, 2023
// Teacher: Ms. Basaraba
// Description: This class animates checkers falling as part of the splash screen

import java.awt.*;
import java.util.Arrays;
import hsa.*;

public class CheckersFall1 extends Thread {
    static Console c;

    public CheckersFall1 (Console con) {
        c = con;
    }

    public void run() {
        // coordinates of the checkers
        int[][] coords = new int[][] {
                {160, 482, 0},
                {160, 455, 1},
                {355, 557, 1},
                {510, 576, 0},
                {629, 605, 1},
        };

        int delay = 550; // initial fall delay

        for (int i = 0; i < coords.length; i ++) {
            // creating array to store the existing checkers and to draw them on the board
            int[][] existingCheckers = new int[i][3];
            System.arraycopy(coords, 0, existingCheckers, 0, i);

            // fall delay
            try {
                Thread.sleep(delay);
            } catch (Exception e) {

            }

            // animates the checker falling
            Checkers.animateFallingChecker(
                    coords[i][0],
                    -10,
                    coords[i][1],
                    coords[i][2] != 0,
                    10,
                    1.01,
                    existingCheckers
            );

            // animation delay
            try {
                Thread.sleep(20);
            } catch (Exception e) {

            }

            delay -= (int) (delay * 0.4); // makes checkers fall faster by decreasing the fall delay
        }
    }
}
