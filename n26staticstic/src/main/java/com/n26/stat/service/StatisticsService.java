package com.n26.stat.service;

import com.n26.stat.model.StatisticsSummary;
import com.n26.stat.model.Transaction;

/**
 * @author Manideepa
 * @since 1.0.0
 */
public interface StatisticsService {

    void computeStatistics(Transaction transaction);

    StatisticsSummary getStatistics();

}
