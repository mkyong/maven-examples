package com.mkyong.example1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApp1 {

    @Test
    @DisplayName("Testing App1")
    public void testApp1() {
        assertEquals(1, 1);
    }

}
