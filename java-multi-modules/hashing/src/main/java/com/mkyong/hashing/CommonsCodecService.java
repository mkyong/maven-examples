package com.mkyong.hashing;

import org.apache.commons.codec.digest.DigestUtils;

// https://commons.apache.org/proper/commons-codec/
public class CommonsCodecService implements DigestService {

    @Override
    public String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }

    @Override
    public String sha512hex(String input) {
        return DigestUtils.sha512Hex(input);
    }

    @Override
    public String md5hex(String input) {
        return DigestUtils.md5Hex(input);
    }

}
