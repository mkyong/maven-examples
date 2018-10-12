package com.mkyong.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPasswordService {

    PasswordService passwordService;

    @BeforeEach
    void init() {
        passwordService = new PasswordServiceImpl();
    }

    @DisplayName("md5 -> hex")
    @ParameterizedTest
    @CsvSource({
            "123456, e10adc3949ba59abbe56e057f20f883e",
            "hello world, 5eb63bbbe01eeed093cb22bb8f5acdc3"
    })
    void testMd5hex(String input, String expected) {
        assertEquals(expected, passwordService.hash(input));
    }

}
