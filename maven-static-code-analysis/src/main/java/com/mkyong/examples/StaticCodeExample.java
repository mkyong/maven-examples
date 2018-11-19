package com.mkyong.examples;

public class StaticCodeExample {

    //Unused field
    private int abc;

    // Do not hard code the IP address
    private String ip = "127.0.0.1";

    public void test() {

        String[] field = {"a", "b", "c", "s", "e"};

        //concatenates strings using + in a loop
        String s = "";
        for (int i = 0; i < field.length; ++i) {
            s = s + field[i];
        }

        System.out.println(ip);

    }

}
