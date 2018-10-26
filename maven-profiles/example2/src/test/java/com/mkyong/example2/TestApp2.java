package com.mkyong.example2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApp2 {

    @Test
    @DisplayName("Testing App2")
    public void testApp2() {
        assertEquals(1, 1);
    }

}