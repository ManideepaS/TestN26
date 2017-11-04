package com.n26.stat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.n26.stat.exception.ValidationException;
import com.n26.stat.model.StatisticsSummary;
import com.n26.stat.model.Transaction;
import com.n26.stat.service.StatisticsService;
import com.n26.stat.service.StatisticsServiceImpl;
import com.n26.stat.service.TransactionService;
import com.n26.stat.service.TransactionServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class N26staticsticApplicationTests {

	@Autowired
    private StatisticsService statisticsService;
	
	@Autowired
    private TransactionService transactionService;


    @Mock
    private StatisticsServiceImpl statisticsServiceMock;

    @InjectMocks
    private TransactionServiceImpl transactionServiceMock;

    @Test
    public void whenOutdatedTimestamp_doNothing(){
        StatisticsSummary summaryBefore = statisticsService.getStatistics();
        statisticsService.computeStatistics(new Transaction(10.5, System.currentTimeMillis() - 60000));
        assertEquals(summaryBefore, statisticsService.getStatistics());
    }

    @Test
    public void whenValidTimestamp_computeStatistics(){
        statisticsService.computeStatistics(new Transaction(5.5, System.currentTimeMillis() - 10000));
        statisticsService.computeStatistics(new Transaction(15.5, System.currentTimeMillis() - 9000));
        statisticsService.computeStatistics(new Transaction(25.2, System.currentTimeMillis() - 8000));
        statisticsService.computeStatistics(new Transaction(65.5, System.currentTimeMillis() - 7000));
        statisticsService.computeStatistics(new Transaction(5.7, System.currentTimeMillis() - 6000));
        statisticsService.computeStatistics(new Transaction(5.8, System.currentTimeMillis() - 5000));
        statisticsService.computeStatistics(new Transaction(3.5, System.currentTimeMillis() - 4000));
        statisticsService.computeStatistics(new Transaction(2.8, System.currentTimeMillis() - 3000));
        statisticsService.computeStatistics(new Transaction(9.5, System.currentTimeMillis() - 2000));
        statisticsService.computeStatistics(new Transaction(12.3, System.currentTimeMillis() - 1000));

        StatisticsSummary summary = statisticsService.getStatistics();
        assertEquals(summary.getCount(), 10l);
        assertEquals(summary.getSum(), 151.3, 0.0);
        assertEquals(summary.getMax(), 65.5, 0.0);
        assertEquals(summary.getMin(), 2.8, 0.0);
        assertEquals(summary.getAvg(), 151.3 / 10, 0.0);
    }  

    @Test(expected = ValidationException.class)
    public void whenEmptyRequestBody_exceptionThrown(){
        transactionService.addTransaction(null);
    }

    @Test(expected = ValidationException.class)
    public void whenMissingTimestampField_exceptionThrown(){
        transactionService.addTransaction(new Transaction(12.5, null));
    }

    @Test(expected = ValidationException.class)
    public void whenMissingAmountField_exceptionThrown(){
        transactionService.addTransaction(new Transaction(null, System.currentTimeMillis()));
    }

    @Test
    public void whenValidTransaction_flowSucceeds(){
        doNothing().when(statisticsServiceMock).computeStatistics(any(Transaction.class));
        transactionServiceMock.addTransaction(new Transaction(12.5, System.currentTimeMillis()));

        verify(statisticsServiceMock, times(1)).computeStatistics(any(Transaction.class));
    }

}
