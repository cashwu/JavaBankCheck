package com.cashwu.javabankcheck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * @author cash.wu
 * @since 2024/06/03
 */
public class BankStatementAnalyzer {
//    private static final String RESOURCES = "src/main/resources/";
    private static final String RESOURCES = "src/main/resources/";

      public void analyze(String fileName,
                          BankStatementParser bankStatementParser) throws IOException {
        Path path = Paths.get(RESOURCES + fileName);
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parseLineFrom(lines);
        var bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private void collectSummary(BankStatementProcessor bankStatementProcessor) {

        System.out.println("total : " + bankStatementProcessor.calculateTotalAmount());

        System.out.println(
                "total in January : " + bankStatementProcessor.calculateTotalAmountInMonth(
                        Month.JANUARY));

        System.out.println(
                "total in February : " + bankStatementProcessor.calculateTotalAmountInMonth(
                        Month.FEBRUARY));

        System.out.println(
                "total salary : " + bankStatementProcessor.calculateForCategory("Salary"));
    }
}
