/*
 * Task 02 - Calculator
 * CSC Nsk Java 2019
 */

package org.csc.nsk.java2017.impl.lanisyutin.task02;

import org.csc.nsk.java2017.task02.BadSyntaxException;
import org.csc.nsk.java2017.task02.CalculationException;
import org.csc.nsk.java2017.task02.Calculator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;


public final class MyAwesomeCalculator implements Calculator {

    private ArrayList<Character> _operations = new ArrayList<>(List.of('*', '/', '-', '+'));

    @Override
    public double calculate(String expression) {
        if (expression.isBlank())
            throw new BadSyntaxException("Bad input");

        if (!isValid(expression))
            throw new BadSyntaxException("Wrong number of parenthesis");

        expression = expression
                .strip()
                .replaceAll(" ", "")
                .toLowerCase();

        expression = removeOuterParenthesis(expression);

        var position = nextOperationAt(expression);

        if (position == -1) {
            return evaluate(expression);
        }

        var operation = expression.charAt(position);
        var left = expression.substring(0, position);
        var right = expression.substring(position + 1);

        double result;
        switch (operation) {
            case '+':
                result = calculate(left) + calculate(right);
                break;
            case '-':
                result = calculate(left) - calculate(right);
                break;
            case '*':
                result = calculate(left) * calculate(right);
                break;
            case '/':
                result = calculate(left) / calculate(right);
                break;
            default:
                throw new BadSyntaxException("Unknown operation");
        }

        if (!Double.isFinite(result))
            throw new CalculationException();

        return result;
    }

    private boolean isValid(String expression){
        var deepLevel = 0;
        char ch;
        for (int i = 0; i < expression.length(); i++) {
            ch = expression.charAt(i);
            if (ch == '(') deepLevel++;
            if (ch == ')') deepLevel--;
            if (deepLevel < 0) return false;
        }

        if (deepLevel > 0)
            throw new BadSyntaxException("Wrong number of parenthesis");

        return true;
    }

    private String removeOuterParenthesis(String expression) {
        int i = 0;
        int length = expression.length();
        while (expression.charAt(i) == '(' &&
                expression.charAt(length - i - 1) == ')' &&
                isValid(expression.substring(i+1, length - 1 - i)))
            i++;

        return expression.substring(i, expression.length() - i);
    }

    private int nextOperationAt(String expression) {
        var deepLevel = 0;
        char ch;
        for (int i = 0; i < expression.length(); i++) {
            ch = expression.charAt(i);
            if (i>0 && _operations.contains(ch) && deepLevel == 0)
                return i;

            if (ch == '(') deepLevel++;
            if (ch == ')') deepLevel--;
        }

        return -1;
    }

    private double evaluate(final String expression) {
        var pos = expression.indexOf('(');

        if (pos == -1)
            return Double.parseDouble(expression);

        var func = expression.substring(0, pos);
        var arg = expression.substring(pos + 1, expression.lastIndexOf(')'));
        switch (func) {
            case "cos":
                return cos(calculate(arg));
            case "sin":
                return sin(calculate(arg));
            case "abs":
                return abs(calculate(arg));
            default:
                throw new BadSyntaxException("Unsupported function");
        }
    }
}
