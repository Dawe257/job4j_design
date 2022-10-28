package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);

        boolean bool = true;
        byte b = 15;
        short s = 16;
        int n = 17;
        long l = 18L;
        char c = 'C';
        float f = 18.5f;
        double d = 19.5d;
        LOG.debug("{} {} {} {} {} {} {} {}", bool, b, s, n, l, c, f, d);
    }
}