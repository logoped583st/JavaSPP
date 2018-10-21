package com.blogspot.nikcode.complex;

/**
 *
 * @author nik
 */
public class ComplexNumber {

    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
    
    public ComplexNumber getSquare() {
        return new ComplexNumber(real * real - imaginary * imaginary, 2 * real * imaginary);
    }

    public ComplexNumber add(ComplexNumber another) {
        return new ComplexNumber(real + another.getReal(), imaginary + another.getImaginary());
    }


}
