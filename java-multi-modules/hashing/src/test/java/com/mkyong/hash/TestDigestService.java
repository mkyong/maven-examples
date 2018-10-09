package com.mkyong.hash;

import com.mkyong.hashing.CommonsCodecService;
import com.mkyong.hashing.DigestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test DigestService...")
public class TestDigestService {

    DigestService digestService;

    @BeforeEach
    void init() {
        digestService = new CommonsCodecService();
    }

    @DisplayName("sha256 -> hex")
    @ParameterizedTest
    @CsvSource({
            "123456, 8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92",
            "hello world, b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9"
    })
    void testSha256hex(String input, String expected) {
        assertEquals(expected, digestService.sha256hex(input));
    }

    @DisplayName("sha512 -> hex")
    @ParameterizedTest
    @CsvSource({
            "123456, ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413",
            "hello world, 309ecc489c12d6eb4cc40f50c902f2b4d0ed77ee511a7c7a9bcd3ca86d4cd86f989dd35bc5ff499670da34255b45b0cfd830e81f605dcf7dc5542e93ae9cd76f"
    })
    void testSha512hex(String input, String expected) {
        assertEquals(expected, digestService.sha512hex(input));
    }

    @DisplayName("md5 -> hex")
    @ParameterizedTest
    @CsvSource({
            "123456, e10adc3949ba59abbe56e057f20f883e",
            "hello world, 5eb63bbbe01eeed093cb22bb8f5acdc3"
    })
    void testMd5hex(String input, String expected) {
        assertEquals(expected, digestService.md5hex(input));
    }

}
