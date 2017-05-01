package com.trade.report;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.trade.report.entity.TradeTO;
import com.trade.util.AmountComparator;
import com.trade.util.DateUtil;

public class TradeReport {

	public void generateReport(List<TradeTO> listOfTrade){
		double incomingAmt=0;
		double outGoingAmt=0;
		List<TradeTO> listOfIncomingTrade = new ArrayList<TradeTO>();
		List<TradeTO> listOfOutgoingTrade = new ArrayList<TradeTO>();
		double tempAmt=0;
		for(TradeTO tradeTO: listOfTrade){
			Calendar actualSettlement = DateUtil.calculateSettlementDate(tradeTO.getSettlementDate(), tradeTO.getCurrency());
			if(tradeTO.getSettlementDate().compareTo(actualSettlement.getTime())==0){
				if("BUY".equalsIgnoreCase(tradeTO.getOption())){
					tempAmt = tradeTO.getPricePerUnit() * tradeTO.getUnits() * tradeTO.getAgreedFx();
					outGoingAmt =  outGoingAmt + tempAmt;
					tradeTO.setTotalPrice(tempAmt);
					listOfOutgoingTrade.add(tradeTO);
				}else{
					tempAmt = tradeTO.getPricePerUnit() * tradeTO.getUnits() * tradeTO.getAgreedFx();
					incomingAmt =  incomingAmt + tempAmt;
					tradeTO.setTotalPrice(tempAmt);
					listOfIncomingTrade.add(tradeTO);
				}
			}
			
		}
		System.out.println("Amount in USD settled outgoing :"+outGoingAmt);
		System.out.println("Amount in USD settled incoming :"+incomingAmt);
		Collections.sort(listOfOutgoingTrade, new AmountComparator());
		System.out.println("Ranking of outgoing entities, Highest on top:-" );
		printTarde(listOfOutgoingTrade);
		Collections.sort(listOfIncomingTrade, new AmountComparator());
		System.out.println("Ranking of incoming entities, Highest on top:-" );
		printTarde(listOfIncomingTrade);
	}
	private void printTarde(List<TradeTO> listOfTrade){
		for(TradeTO inTradeTO: listOfTrade){
			System.out.println(inTradeTO.getEntityName());
			System.out.println("\n");
		}
	}
}
