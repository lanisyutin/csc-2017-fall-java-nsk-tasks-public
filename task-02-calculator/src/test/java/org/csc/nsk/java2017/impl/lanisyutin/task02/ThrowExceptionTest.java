package org.csc.nsk.java2017.impl.lanisyutin.task02;

import org.csc.nsk.java2017.task02.BadSyntaxException;
import org.csc.nsk.java2017.task02.CalculationException;
import org.csc.nsk.java2017.task02.Calculator;
import org.junit.jupiter.api.Test;

import static org.csc.nsk.java2017.impl.lanisyutin.task02.CalculatorFactory.makeCalculator;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ThrowExceptionTest {
    private final Calculator _calculator = makeCalculator();

    @Test
    void badParenthesis() {
        assertThrows(BadSyntaxException.class, () -> {
            _calculator.calculate("  1 +cos(11- abs(2-3.141)");
        });
    }

    @Test
    void emptyInput() {
        assertThrows(BadSyntaxException.class, () -> {
            _calculator.calculate("  ");
        });
    }

    @Test
    void divideByZeroExc() {
        assertThrows(CalculationException.class, () -> {
            _calculator.calculate("  1/0");
        });
    }

}