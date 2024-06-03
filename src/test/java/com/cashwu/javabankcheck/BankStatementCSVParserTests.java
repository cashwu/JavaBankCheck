package com.cashwu.javabankcheck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author cash.wu
 * @since 2024/06/03
 */
public class BankStatementCSVParserTests {

    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() {

        String line = "30-01-2007,-50,Tesco";

        BankTransaction bankTransaction = bankStatementParser.parseFrom(line);

        BankTransaction expected = new BankTransaction(LocalDate.of(2007, Month.JANUARY, 30), -50,
                                                       "Tesco");

        Assertions.assertEquals(expected, bankTransaction);

        //        Assertions.assertEquals(expected.getDate(), bankTransaction.getDate());
        //        Assertions.assertEquals(expected.getAmount(), bankTransaction.getAmount());
        //        Assertions.assertEquals(expected.getDescription(), bankTransaction.getDescription());
    }
}
