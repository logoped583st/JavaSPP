package com.blogspot.nikcode.complex.ui;

import com.blogspot.nikcode.complex.ComplexNumber;
import com.blogspot.nikcode.complex.MandelbrotSetCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Set;

/**
 * @author nik
 */
public class MandelbrotSetPanel extends JPanel {

    private boolean isFirstPaint = true;
    private int screenCenterX;
    private int screenCenterY;
    private int axesCenterX;
    private int axesCenterY;
    private double realStart;
    private double realEnd;
    private double imaginaryStart;
    private double imaginaryEnd;
    private int currentZoom = 1;

    public MandelbrotSetPanel() {
        super();
        this.setBackground(Color.WHITE);
        // this.addMouseListener(mouseListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (isFirstPaint) {
            init();
        }
        g.drawLine(0, axesCenterY, getWidth(), axesCenterY);
        g.drawLine(axesCenterX, 0, axesCenterX, getHeight());

        Set<ComplexNumber> mandelbrotSet = MandelbrotSetCalculator.computeSet(realStart, realEnd, imaginaryStart, imaginaryEnd,
                0.005 / currentZoom, 0.005 / currentZoom);
        for (ComplexNumber complexNumber : mandelbrotSet) {
            double x = axesCenterX + complexNumber.getReal() * getRealSegmentSize();
            double y = axesCenterY + complexNumber.getImaginary() * getImaginarySegmentSize();
            g2d.draw(new Line2D.Double(x, y, x, y));
        }
    }


    private void init() {
        screenCenterX = this.getWidth() / 2;
        screenCenterY = this.getHeight() / 2;
        axesCenterX = screenCenterX;
        axesCenterY = screenCenterY;
        realStart = -2;
        realEnd = 2;
        double firstIterationSegmentSize = getRealSegmentSize();
        double imaginarySegmentCount = getHeight() / firstIterationSegmentSize;
        imaginaryStart = -(imaginarySegmentCount / 2);
        imaginaryEnd = imaginarySegmentCount / 2;

        isFirstPaint = false;
    }

    private double getRealSegmentCount() {
        return realEnd - realStart;
    }

    private double getRealSegmentSize() {
        return getWidth() / getRealSegmentCount();
    }

    private double getImaginarySegmentCount() {
        return imaginaryEnd - imaginaryStart;
    }

    private double getImaginarySegmentSize() {
        return getHeight() / getImaginarySegmentCount();
    }
}
