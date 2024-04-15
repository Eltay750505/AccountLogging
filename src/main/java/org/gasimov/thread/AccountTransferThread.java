package org.gasimov.thread;

import org.apache.log4j.Logger;
import org.gasimov.model.Account;
import org.gasimov.service.AccountService;
import org.gasimov.util.RandomUtil;

import java.math.BigDecimal;
import java.util.Random;

import static org.gasimov.util.ConstantUtil.maxTransferSumValue;
import static org.gasimov.util.ConstantUtil.minTransferSumValue;

public class AccountTransferThread extends Thread {
    private static final AccountService accountService = new AccountService();
    private static final Logger logger = Logger.getLogger(AccountTransferThread.class);
    private final Account firstAccount;
    private final Account secondAccount;
    private static final Random random = new Random();

    public AccountTransferThread(Account firstAccount, Account secondAccount) {
        this.firstAccount = firstAccount;
        this.secondAccount = secondAccount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
            logger.info("Started transfer.");
            accountService.transferMoney(
                    firstAccount,
                    secondAccount,
                    BigDecimal.valueOf(RandomUtil.getRandomNumberFromRange(minTransferSumValue, maxTransferSumValue))
            );
            logger.info("Ended transfer.");
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
