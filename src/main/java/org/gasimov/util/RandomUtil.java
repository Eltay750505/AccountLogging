package org.gasimov.util;

import static org.gasimov.util.ConstantUtil.random;

public class RandomUtil {
    public static int getRandomNumberFromRange(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
