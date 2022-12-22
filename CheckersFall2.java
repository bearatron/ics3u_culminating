// Names: Ethan Diep and Glen Lin
// Date: December 23, 2022
// Teacher: Ms. Basaraba
// Description: This class animates checkers falling as part of the splash screen

import java.awt.*;
import hsa.*;

public class CheckersFall2 extends Thread {
    static Console c;

    public CheckersFall2 (Console con) {
        c = con;
    }

    public void run() {
        // coordinates of the checkers
        int[][] coords = new int[][] {
                {340, 638, 0},
                {755, 566, 1},
                {755, 541, 0},
                {755, 516, 1},
                {755, 491, 0},
        };

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        int delay = 120; // controls the fall delay

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
                    1.02,
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
