package org.csc.nsk.java2017.impl.lanisyutin.task02;

import org.csc.nsk.java2017.task02.Calculator;
import org.junit.jupiter.api.Test;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.csc.nsk.java2017.impl.lanisyutin.task02.CalculatorFactory.makeCalculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsTest {
    private final Calculator _calculator = makeCalculator();
    private final double DELTA = 1e-7;


    @Test
    void simpleCos() {
        assertEquals(_calculator.calculate("cos(12)"), cos(12), DELTA);
    }

    @Test
    void simpleSin() {
        assertEquals(_calculator.calculate("sin(12)"), sin(12), DELTA);
    }

    @Test
    void simpleAbs() {
        assertEquals(_calculator.calculate("abs(2-81)"), 79, DELTA);
    }

    @Test
    void notSimple() {
        assertEquals(_calculator.calculate("  1 +cos(11- abs(2-3.141))"), 0.0928023914, DELTA);
    }
}