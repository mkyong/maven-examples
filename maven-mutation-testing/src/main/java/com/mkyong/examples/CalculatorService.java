package com.mkyong.examples;

public class CalculatorService {

    public boolean isPositive(int number) {

        boolean result = false;
        if (number >= 0) {
            result = true;
        }
        return result;

    }

}
