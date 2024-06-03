package com.cashwu.javabankcheck;

import java.util.List;

/**
 * @author cash.wu
 * @since 2024/06/03
 */
public interface BankStatementParser {
    List<BankTransaction> parseLineFrom(List<String> lines);

    BankTransaction parseFrom(String line);
}
