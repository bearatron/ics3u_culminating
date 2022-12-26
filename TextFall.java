// Names: Ethan Diep and Glen Lin
// Date: December 23, 2022
// Teacher: Ms. Basaraba
// Description: This class animates the title text falling as part of the splash screen

import java.awt.*;
import hsa.*;

public class TextFall extends Thread {
    Console c;

    public TextFall (Console con) {
        c = con;
    }

    public void run() {
        int bgR = 182;
        int bgG = 215;
        int bgB = 168;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        while(bgR > 0 && bgG > 0 && bgB > 0) {
            bgR -= 2;
            bgG -= 2;
            bgB -= 2;

            c.setColor(new Color(182, 215, 168));
            c.fillRect(235, 243, 595, 80);

            c.setColor(new Color(bgR, bgG, bgB));
            c.setFont(new Font ("Serif", Font.BOLD, 100));
            c.drawString("CHECKERS", 235, 243);

            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }

        c.setColor(new Color(0, 0, 0));
        c.setFont(new Font ("Serif", Font.BOLD, 100));
        c.drawString("CHECKERS", 235, 243);
    }
}
