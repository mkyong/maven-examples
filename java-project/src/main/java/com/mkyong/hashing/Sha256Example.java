package com.mkyong.hashing;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Example {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String password = "123456";

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] hashInBytes = md.digest(password.getBytes(Charsets.UTF_8));

        System.out.println(bytesToHex(hashInBytes));
        System.out.println(bytesToHex2(hashInBytes));
        System.out.println(bytesToHex3(hashInBytes));
        
        //common-codec
        String sha256hex = DigestUtils.sha256Hex(password);
        System.out.println(sha256hex);

    }

    private static String bytesToHex(byte[] hashInBytes) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hashInBytes.length; i++) {
            sb.append(Integer.toString((hashInBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();

    }

    private static String bytesToHex2(byte[] hashInBytes) {

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hashInBytes.length; i++) {
            String hex = Integer.toHexString(0xff & hashInBytes[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();

    }

    private static String bytesToHex3(byte[] hashInBytes) {

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }

}
