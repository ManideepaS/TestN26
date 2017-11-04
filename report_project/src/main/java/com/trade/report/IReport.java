package com.trade.report;

import java.util.List;

import com.trade.report.entity.TradeTO;

@FunctionalInterface
public interface IReport {
	public void generateReport(List<TradeTO> listOfTrade);
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	static void log1(String str){
		System.out.println("I1 logging::"+str);
	}
}
