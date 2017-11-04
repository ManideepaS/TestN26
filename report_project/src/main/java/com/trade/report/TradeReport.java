package com.trade.report;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

import com.trade.report.entity.TradeTO;
import com.trade.util.AmountComparator;
import com.trade.util.DateUtil;

public class TradeReport implements IReport{

	public void generateReport(List<TradeTO> listOfTrade){
		OptionalDouble incomingAmt=OptionalDouble.empty();
		OptionalDouble outGoingAmt=OptionalDouble.empty();
		List<TradeTO> listOfIncomingTrade = new ArrayList<TradeTO>();
		List<TradeTO> listOfOutgoingTrade = new ArrayList<TradeTO>();
		double tempAmt=0;
		if(listOfTrade!=null && !listOfTrade.isEmpty()){
		for(TradeTO tradeTO: listOfTrade){
			Calendar actualSettlement = DateUtil.calculateSettlementDate(tradeTO.getSettlementDate(), tradeTO.getCurrency());
			if(tradeTO.getSettlementDate().compareTo(actualSettlement.getTime())==0){
				if("BUY".equalsIgnoreCase(tradeTO.getOption())){
					tempAmt = tradeTO.getPricePerUnit() * tradeTO.getUnits() * tradeTO.getAgreedFx();
					if(outGoingAmt.isPresent()){
						outGoingAmt = OptionalDouble.of(outGoingAmt.getAsDouble() + tempAmt);
					}else{
						outGoingAmt = OptionalDouble.of(tempAmt);
					}
					tradeTO.setTotalPrice(tempAmt);
					listOfOutgoingTrade.add(tradeTO);
				}else{
					tempAmt = tradeTO.getPricePerUnit() * tradeTO.getUnits() * tradeTO.getAgreedFx();
					//incomingAmt =  incomingAmt + tempAmt;
					tradeTO.setTotalPrice(tempAmt);
					listOfIncomingTrade.add(tradeTO);
				}
			}
			
		}
		System.out.println("Amount in USD settled outgoing :"+outGoingAmt);
		IReport tradeReport = (List<TradeTO> listOfTrade1) -> System.out.println("Amount in USD settled outgoing :"+listOfTrade1.stream().iterator().next());
		tradeReport.generateReport(listOfTrade);
		IReport.log1("aaa");
		System.out.println("Amount in USD settled incoming :"+incomingAmt);
		Collections.sort(listOfOutgoingTrade, new AmountComparator());
		System.out.println("Ranking of outgoing entities, Highest on top:-" );
		printTarde(listOfOutgoingTrade);
		Collections.sort(listOfIncomingTrade, new AmountComparator());
		System.out.println("Ranking of incoming entities, Highest on top:-" );
		printTarde(listOfIncomingTrade);
		}
		
	}
	
	private void printTarde(List<TradeTO> listOfTrade){
		for(TradeTO inTradeTO: listOfTrade){
			System.out.println(inTradeTO.getEntityName());
			System.out.println("\n");
		}
	}
}
