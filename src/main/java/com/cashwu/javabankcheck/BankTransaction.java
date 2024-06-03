package com.cashwu.javabankcheck;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author cash.wu
 * @since 2024/06/03
 */
@Data
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(LocalDate date,
                           double amount,
                           String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
}
