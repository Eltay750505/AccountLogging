package org.gasimov.service;

import org.apache.log4j.Logger;
import org.gasimov.Main;
import org.gasimov.model.Account;

import java.math.BigDecimal;

public class AccountService {
    private static final Logger logger = Logger.getLogger(Main.class);

    public void transferMoney(Account from, Account to, BigDecimal amount) {
        BigDecimal subtract = from.getMoney().subtract(amount);
        if (subtract.compareTo(BigDecimal.ZERO) >= 0) {
            from.setMoney(subtract);
            to.setMoney(to.getMoney().add(amount));
            logger.info("Transfer money from account with id - " + from.getId() + " to " + to.getId());
            logger.info("Account " + from.getId() + " current amount is - " + from.getMoney());
            logger.info("Account " + to.getId() + " current amount is - " + to.getMoney());
        } else {
            logger.error("Account " + from.getId() + " don't have enough money");
        }
    }
}
