package com.mkyong.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculatorService {

    @Test
    public void testPositive() {

        CalculatorService obj = new CalculatorService();
        assertEquals(true, obj.isPositive(10));
        //kill mutation #1
        assertEquals(true, obj.isPositive(0));

    }

}
