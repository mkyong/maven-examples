package com.mkyong.hashing;

public interface DigestService {

    String sha256hex(String input);

    String sha512hex(String input);

    String md5hex(String input);

}