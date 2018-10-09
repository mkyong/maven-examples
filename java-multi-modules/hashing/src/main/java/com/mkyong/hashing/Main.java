package com.mkyong.hashing;

public class Main {

    public static void main(String[] args) {

        DigestService digest = new CommonsCodecService();

        if (args.length != 2) {
            printSyntax();
        }

        String algo = args[0];
        String input = args[1];

        if (input.isEmpty()) {
            printSyntax();
        }

        String result = "";

        if (algo.equalsIgnoreCase("md5")) {
            result = digest.md5hex(input);
        } else if (algo.equalsIgnoreCase("sha256")) {
            result = digest.sha256hex(input);
        } else if (algo.equalsIgnoreCase("sha512")) {
            result = digest.sha512hex(input);
        } else {
            printSyntax();
        }

        System.out.println(result);

    }

    private static void printSyntax() {
        System.err.println("Usage : java -jar [md5|sha256|sha512] input");
        System.exit(0);
    }

}
