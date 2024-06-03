package com.cashwu.javabankcheck;

import java.time.Month;
import java.util.List;

/**
 * @author cash.wu
 * @since 2024/06/03
 */
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    double calculateTotalAmount() {

        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            total = bankTransaction.getAmount();
        }

        return total;
    }

    double calculateTotalAmountInMonth(Month month) {

        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {

            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }
    double calculateForCategory(String category) {

        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {

            if (bankTransaction.getDescription().equals(category))  {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }


}
