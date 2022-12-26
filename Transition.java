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
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        int i = 0;
        while (i <= 260) {
            c.setColor(new Color(255,255,255,Math.min(i, 255)));
            c.fillRect(0, 0, 1024, 728);
            i += 100;
            try {
                Thread.sleep(1);
            } catch (Exception e) {}
        }
        i = 0;
        while (i <= 260) {
            c.setColor(new Color(182,215,168,Math.min(i, 255)));
            c.fillRect(0, 0, 1024, 728);
            i += 50;
            try {
                Thread.sleep(1);
            } catch (Exception e) {}
        }
    }
}
