package com.cashwu.javabankcheck;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cash.wu
 * @since 2024/06/03
 */
public class BankStatementCSVParser implements BankStatementParser {

    private static final DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public List<BankTransaction> parseLineFrom(List<String> lines) {
        var bankTransactions = new ArrayList<BankTransaction>();
        for (String line : lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }

    @Override
    public BankTransaction parseFrom(String line) {
        String[] columns = line.split(",");

        LocalDate date = LocalDate.parse(columns[0], datePattern);
        var amount = Double.parseDouble(columns[1]);
        String description = columns[2];

        return new BankTransaction(date, amount, description);
    }
}
