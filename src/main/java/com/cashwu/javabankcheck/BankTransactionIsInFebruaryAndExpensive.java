package com.cashwu.javabankcheck;

import java.time.Month;

/**
 * @author cash.wu
 * @since 2024/06/04
 */
public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }
}
