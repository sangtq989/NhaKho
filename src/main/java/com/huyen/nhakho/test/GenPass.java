package com.huyen.nhakho.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenPass {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String raw ="123456";
        String encoded = encoder.encode(raw);
        System.out.println(encoded);
    }
}
