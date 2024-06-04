package com.cashwu.javabankcheck;

import java.time.Month;
import java.util.ArrayList;
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

    public double summarizeTransactions(BankTransactionSummarizer bankTransactionSummarizer) {

        double result = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }

        return result;
    }

    double calculateTotalAmount() {

        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            total = bankTransaction.getAmount();
        }

        return total;
    }

    public double calculateTotalAmountInMonth(Month month) {

        return summarizeTransactions(
                (acc, bankTransaction) -> bankTransaction.getDate().getMonth() == month ?
                        acc + bankTransaction.getAmount() :
                        acc);
    }

    public double calculateForCategory(String category) {

        return summarizeTransactions(
                (acc, bankTransaction) -> bankTransaction.getDescription().equals(category) ?
                        acc + bankTransaction.getAmount() :
                        acc);
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter) {

        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {

            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }

        return result;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(int amount) {

        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= 1_000);
    }

}


