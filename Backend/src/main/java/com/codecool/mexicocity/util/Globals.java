package com.codecool.mexicocity.util;

import java.security.SecureRandom;
import java.util.Random;

public class Globals {

    private static final Random RANDOM = new SecureRandom();

    public static Random getRANDOM() {
        return RANDOM;
    }
}
