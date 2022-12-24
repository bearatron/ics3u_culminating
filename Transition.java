// Names: Ethan Diep and Glen Lin
// Date: December 23, 2022
// Teacher: Ms. Basaraba
// Description: This class animates the transition between the splash screen and main menu

import java.awt.*;
import hsa.*;

public class Transition extends Thread {
    Console c;

    public Transition (Console con) {
        c = con;
    }

    public void run() {
        int size = 0;

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        while (size < 1500) {
            c.setColor(Color.BLACK);
            c.fillOval(1024/2 - size/2, 728/2 - size/2, size, size);

            size += 15;

            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
    }
}
