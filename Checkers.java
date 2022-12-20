// Names: Ethan Diep and Glen Lin
// Date: December 13, 2022
// Teacher: Ms. Basaraba
// Description: This program makes a checkers game in the Console window

import java.awt.*;
import hsa.*;

public class Checkers {
    Console c;
    public static void main(String[] args) {
        Checkers g = new Checkers();
        g.splashScreen();
    }

    public Checkers() {
        c = new Console(39, 128);
    }

    public void splashScreen() {
        checkersFall1();
        checkersFall2();
        textFall();
        transition();
    }

    public void checkersFall1() {
        CheckersFall1 cf1 = new CheckersFall1(c);
    }

    public void checkersFall2() {
        CheckersFall2 cf2 = new CheckersFall2(c);
    }

    public void textFall() {
        TextFall tf = new TextFall(c);
    }

    public void transition() {
        Transition tr = new Transition(c);
    }
}
