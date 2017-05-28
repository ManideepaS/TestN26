/**
 * 
 */
package com.trade.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.trade.report.TradeReport;
import com.trade.report.entity.TradeTO;
import com.trade.test.mock.MockTrade;
import com.trade.util.DateUtil;

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
	public void testSettlementDateNull() throws ParseException {
		assertNull(DateUtil.calculateSettlementDate(null, null));
	}
	@Test
	public void testSettlementDateSame() throws ParseException {
		//Test DateUtil method
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		List<TradeTO> mockDataList = MockTrade.getMockData();
		assertEquals(sdf.parse("04/01/16"), DateUtil.calculateSettlementDate(mockDataList.get(0).getSettlementDate(), mockDataList.get(0).getCurrency()).getTime());
	}
	@Test
	public void testSettlementDateNotSame() throws ParseException {
		//Test DateUtil method
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		List<TradeTO> mockDataList = MockTrade.getMockData();
		assertNotEquals(sdf.parse("01/01/16"), DateUtil.calculateSettlementDate(mockDataList.get(1).getSettlementDate(), mockDataList.get(1).getCurrency()).getTime());
	}
	@Test
	public void testGenerateReport() throws ParseException {
		TradeReport tradeReport = new TradeReport();
		tradeReport.generateReport(MockTrade.getMockData());
	}
	@Test
	public void testGenerateReportNull() throws ParseException {
		TradeReport tradeReport = new TradeReport();
		tradeReport.generateReport(null);
	}
}
