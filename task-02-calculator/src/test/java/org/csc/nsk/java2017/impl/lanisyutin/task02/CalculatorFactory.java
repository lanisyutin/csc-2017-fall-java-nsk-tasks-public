/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.impl.lanisyutin.task02;

import org.csc.nsk.java2017.task02.Calculator;

final class CalculatorFactory {
    static Calculator makeCalculator() {
        // TODO (task02): replace this with your calculator instance creation
        return new MyAwesomeCalculator();
    }

    private CalculatorFactory() {
    }
}
