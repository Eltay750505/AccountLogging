package org.gasimov.util;

import java.math.BigDecimal;
import java.util.Random;

public class ConstantUtil {
    public static final int accountsCount = 4;
    public static final int minIdValue = 0;
    public static final int maxIdValue = 50;
    public static final BigDecimal baseMoneyValue = BigDecimal.valueOf(10000);
    public static final Random random = new Random();
    public static final int minAccountSequenceValue = 0;
    public static final int maxAccountSequenceValue = 3;
    public static final int minTransferSumValue = 0;
    public static final int maxTransferSumValue = 500;
    public static final int threadCount = 2;
}
