package org.gasimov.service;

import org.apache.log4j.Logger;
import org.gasimov.Main;
import org.gasimov.model.Account;
import org.gasimov.util.RandomUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.gasimov.util.ConstantUtil.*;

public class AccountService {
    private static final Logger logger = Logger.getLogger(Main.class);

    public synchronized void transferMoney(Account from, Account to, BigDecimal amount) {
        BigDecimal subtract = from.getMoney().subtract(amount);
        if (subtract.compareTo(BigDecimal.ZERO) >= 0) {
            from.setMoney(subtract);
            to.setMoney(to.getMoney().add(amount));
            logger.info("Transfer " + amount + " money from account with id - " + from.getId() + " to " + to.getId());
            logger.info("Account " + from.getId() + " current amount is - " + from.getMoney());
            logger.info("Account " + to.getId() + " current amount is - " + to.getMoney());
        } else {
            logger.error("Account " + from.getId() + " don't have enough money");
        }
    }

    public List<Account> getRandomAccounts(int count) {
        List<Account> accounts = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            Long randomId = (long) (RandomUtil.getRandomNumberFromRange(minIdValue, maxIdValue));

            accounts.add(new Account(randomId, baseMoneyValue));
        }
        return accounts;
    }

    public int getSecpndPairAccountId(int firstAccountId, int accountsSize) {
        int secondAccountId;
        do {
            secondAccountId = random.nextInt(accountsSize);
        } while (secondAccountId == firstAccountId);
        return secondAccountId;
    }
}
