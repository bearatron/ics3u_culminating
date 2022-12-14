// Names: Ethan Diep and Glen Lin
// Date: December 13, 2022
// Teacher: Ms. Basaraba
// Description: This program makes a checkers game in the Console window

import hsa.*;
import java.awt.*;
public class Checkers {
    Console c;
    public static void main(String[] args) {
        Checkers g = new Checkers();
        g.test();
    }

    public void test() {
        c.println("Hello world");
    }

    public Checkers() {
        c = new Console(39, 128);
    }
}
