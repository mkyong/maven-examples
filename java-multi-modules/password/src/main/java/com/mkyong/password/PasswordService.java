package com.mkyong.password;

public interface PasswordService {

    String hash(String input);

    String algorithm();

}