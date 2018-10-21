package com.blogspot.nikcode.complex.ui;

import javax.swing.JFrame;

/**
 *
 * @author nik
 */
public class MandelbrotSetFrame extends JFrame {
    
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 400;

    public MandelbrotSetFrame() {
        super("Mandelbrot Set");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 200);
        this.add(new MandelbrotSetPanel());
    }
}
