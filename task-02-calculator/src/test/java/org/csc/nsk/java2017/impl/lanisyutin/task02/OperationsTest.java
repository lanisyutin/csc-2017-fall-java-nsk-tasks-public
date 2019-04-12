package org.csc.nsk.java2017.impl.lanisyutin.task02;

import org.csc.nsk.java2017.task02.Calculator;
import org.junit.jupiter.api.Test;

import static org.csc.nsk.java2017.impl.lanisyutin.task02.CalculatorFactory.makeCalculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationsTest {
    private final Calculator _calculator = makeCalculator();
    private final double DELTA = 1e-7;

    @Test
    void onePlusOne() {
        assertEquals(_calculator.calculate("1 + 1"), 2, DELTA);
    }

    @Test
    void simpleSum() {
        assertEquals(_calculator.calculate("1 + 1.2685"), 2.2685, DELTA);
    }

    @Test
    void simpleSub() {
        assertEquals(_calculator.calculate("1 - 1.2685"), -0.2685, DELTA);
    }

    @Test
    void simpleMult() {
        assertEquals(_calculator.calculate("1 * 2.5"), 2.5, DELTA);
    }

    @Test
    void simpleDiv() {
        assertEquals(_calculator.calculate("5 / 2"), 2.5, DELTA);
    }

    @Test
    void sumWithParenthesis() {
        assertEquals(_calculator.calculate("3+(1 + 1.2685)"), 5.2685, DELTA);
    }

    @Test
    void manyParenthesis() {
        assertEquals(_calculator.calculate("3+(-1 + (1.2685*((-5))))"), -4.3425, DELTA);
    }

    @Test
    void manyParenthesis2() {
        assertEquals(_calculator.calculate("(-1+(1))"), 0, DELTA);
    }

    @Test
    void noParenthesis() {
        assertEquals(_calculator.calculate("(-1+1)*(1 - 1)"), 0, DELTA);
    }

    @Test
    void noParenthesis2() {
        assertEquals(_calculator.calculate("  -11-1"), -12, DELTA);
    }

    @Test
    void noParenthesis3() {
        assertEquals(_calculator.calculate("  -11"), -11, DELTA);
    }
}