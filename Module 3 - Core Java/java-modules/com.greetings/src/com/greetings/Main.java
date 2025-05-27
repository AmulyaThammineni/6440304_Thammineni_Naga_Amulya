package com.greetings;

import com.utils.StringUtils;

public class Main {
    public static void main(String[] args) {
        String message = "hello from Java modules";
        String upper = StringUtils.toUpperCase(message);
        System.out.println(upper);
    }
}
