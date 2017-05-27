/**
 * 
 */
package com.trade.test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.trade.report.TradeReport;
import com.trade.test.mock.MockTrade;

/**
 * @author Manideepa
 *
 */
public class TradeTest {

	/**
	 * Test method for {@link com.trade.report.TradeReport#generateReport(java.util.List)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGenerateReport() throws ParseException {
		TradeReport tradeReport = new TradeReport();
		tradeReport.generateReport(MockTrade.getMockData());
	}

}
