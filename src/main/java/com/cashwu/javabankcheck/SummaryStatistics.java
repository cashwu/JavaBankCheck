package com.cashwu.javabankcheck;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cash.wu
 * @since 2024/06/04
 */
@Data
@AllArgsConstructor
public class SummaryStatistics {

    private final double sum;
    private final double max;
    private final double min;
    private final double average;

}
