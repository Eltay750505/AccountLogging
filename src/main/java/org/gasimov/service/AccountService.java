package org.gasimov.service;

import org.apache.log4j.Logger;
import org.gasimov.Main;
import org.gasimov.model.Account;

import java.math.BigDecimal;

public class AccountService {
    private static final Logger logger = Logger.getLogger(Main.class);

    public void transferMoney(Account from, Account to, BigDecimal amount) {
        from.setMoney(from.getMoney().subtract(amount));
        to.setMoney(to.getMoney().add(amount));
        logger.info("Transfer money from account with id - " + from.getId() + " to " + to.getId());
    }
}
