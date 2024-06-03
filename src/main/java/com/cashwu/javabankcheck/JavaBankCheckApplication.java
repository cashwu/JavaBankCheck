package com.cashwu.javabankcheck;

import java.io.IOException;

//@SpringBootApplication
public class JavaBankCheckApplication {

    public static void main(String[] args) throws IOException {
        //        SpringApplication.run(JavaBankCheckApplication.class, args);

        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);
    }

}
