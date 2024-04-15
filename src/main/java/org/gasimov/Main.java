package org.gasimov;

import org.gasimov.model.Account;
import org.gasimov.service.AccountService;
import org.gasimov.thread.AccountTransferThread;
import org.gasimov.util.RandomUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.gasimov.util.ConstantUtil.*;


public class Main {

    private static final AccountService accountService = new AccountService();

    public static void main(String[] args) {
        List<Account> accounts = accountService.getRandomAccounts(accountsCount);
        int firstAccountId = RandomUtil.getRandomNumberFromRange(minAccountSequenceValue, maxAccountSequenceValue);
        int secondAccountId = accountService.getSecpndPairAccountId(firstAccountId, accounts.size());
        int thirdAccountId = RandomUtil.getRandomNumberFromRange(minAccountSequenceValue, maxAccountSequenceValue);
        int fourthAccountId = accountService.getSecpndPairAccountId(thirdAccountId, accounts.size());

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 15; i++) {
            executor.execute(new AccountTransferThread(accounts.get(firstAccountId), accounts.get(secondAccountId)));
            executor.execute(new AccountTransferThread(accounts.get(thirdAccountId), accounts.get(fourthAccountId)));
        }

        executor.shutdown();
    }
}