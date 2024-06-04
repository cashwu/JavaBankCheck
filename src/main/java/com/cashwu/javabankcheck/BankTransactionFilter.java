package com.cashwu.javabankcheck;

/**
 * @author cash.wu
 * @since 2024/06/04
 */
@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);
}
