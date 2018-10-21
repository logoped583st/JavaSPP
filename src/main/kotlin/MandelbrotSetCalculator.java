package com.blogspot.nikcode.complex;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nik
 */
public final class MandelbrotSetCalculator {
    
    private static final int ITERATIONS_COUNT = 150;
    private static final int BOUND_RADIUS_SQUARE = 2 * 2;

    private MandelbrotSetCalculator() {
    }

    public static boolean isConvergence(ComplexNumber startNumber) {
        ComplexNumber prevResult = new ComplexNumber(0, 0);
        for (int i = 0; i < ITERATIONS_COUNT; i++) {
            prevResult = prevResult.getSquare().add(startNumber);
            double resultAbs = prevResult.getReal() * prevResult.getReal() 
                    + prevResult.getImaginary() * prevResult.getImaginary();
            if (resultAbs > BOUND_RADIUS_SQUARE) {
                return false;
            }
        }
        return true;
    }
    
    public static Set<ComplexNumber> computeSet(double realAxisStart, double realAxisStop, double iAxisStart, 
            double iAxisStop, double realAxisStep, double iAxisStep) {
        Set<ComplexNumber> mandelbrotSet = new HashSet<>();
        for (double r = realAxisStart; r <= realAxisStop; r += realAxisStep) {
            for (double i = iAxisStart; i <= iAxisStop; i+= iAxisStep) {
                ComplexNumber numberToCheck = new ComplexNumber(r, i);
                if (isConvergence(numberToCheck)) {
                    mandelbrotSet.add(numberToCheck);
                }
            }
        }
        return mandelbrotSet;
    }
}
