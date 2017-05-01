package com.trade.test.mock;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.trade.report.entity.TradeTO;

public class MockTrade {
	public static List<TradeTO> getMockData() throws ParseException{
		List<TradeTO> listOfTrade = new ArrayList<TradeTO>();
		TradeTO tradeTO = new TradeTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		tradeTO.setAgreedFx(0.50);
		tradeTO.setCurrency("SGP");
		tradeTO.setEntityName("foo");
		tradeTO.setInstructionDate(sdf.parse("01/01/16"));
		tradeTO.setOption("Buy");
		tradeTO.setPricePerUnit(100.25);
		tradeTO.setSettlementDate(sdf.parse("04/01/16"));
		tradeTO.setUnits(200);
		listOfTrade.add(tradeTO);
		
		tradeTO = new TradeTO();
		tradeTO.setAgreedFx(0.22);
		tradeTO.setCurrency("AED");
		tradeTO.setEntityName("bar");
		tradeTO.setInstructionDate(sdf.parse("01/01/16"));
		tradeTO.setOption("Sell");
		tradeTO.setPricePerUnit(125.5);
		tradeTO.setSettlementDate(sdf.parse("04/01/16"));
		tradeTO.setUnits(450);
		listOfTrade.add(tradeTO);
		
		tradeTO = new TradeTO();
		tradeTO.setAgreedFx(0.50);
		tradeTO.setCurrency("SGP");
		tradeTO.setEntityName("foo");
		tradeTO.setInstructionDate(sdf.parse("01/01/16"));
		tradeTO.setOption("Sell");
		tradeTO.setPricePerUnit(100.25);
		tradeTO.setSettlementDate(sdf.parse("04/01/16"));
		tradeTO.setUnits(200);
		listOfTrade.add(tradeTO);
		
		tradeTO = new TradeTO();
		tradeTO.setAgreedFx(0.50);
		tradeTO.setCurrency("SGP");
		tradeTO.setEntityName("foo1");
		tradeTO.setInstructionDate(sdf.parse("01/01/16"));
		tradeTO.setOption("Buy");
		tradeTO.setPricePerUnit(150.25);
		tradeTO.setSettlementDate(sdf.parse("04/01/16"));
		tradeTO.setUnits(200);
		listOfTrade.add(tradeTO);
		
		tradeTO = new TradeTO();
		tradeTO.setAgreedFx(0.22);
		tradeTO.setCurrency("AED");
		tradeTO.setEntityName("bar2");
		tradeTO.setInstructionDate(sdf.parse("01/01/16"));
		tradeTO.setOption("Sell");
		tradeTO.setPricePerUnit(123.5);
		tradeTO.setSettlementDate(sdf.parse("04/01/16"));
		tradeTO.setUnits(450);
		listOfTrade.add(tradeTO);
		return listOfTrade;
	}
}
