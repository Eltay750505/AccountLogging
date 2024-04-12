package org.gasimov;


import org.apache.log4j.Logger;
import org.gasimov.model.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        int accountsCount = 4;
        BigDecimal baseMoneyValue = BigDecimal.valueOf(10000);
        List<Account> accounts = new ArrayList<>();
        Random random = new Random();
        int lowerBound = 0;
        int upperBound = 50;

        for (int i = 1; i <= accountsCount; i++) {
            Long randomId = (long) (random.nextInt(upperBound - lowerBound + 1) + lowerBound);

            accounts.add(new Account(randomId, baseMoneyValue));
            logger.debug("account with id - " + randomId + " created");
        }
    }
}