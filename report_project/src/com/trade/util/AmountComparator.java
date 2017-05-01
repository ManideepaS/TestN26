package com.trade.util;

import java.util.Comparator;

import com.trade.report.entity.TradeTO;

public class AmountComparator implements Comparator<TradeTO> {
    @Override
    public int compare(TradeTO t1, TradeTO t2) {
        return Double.compare(t2.getTotalPrice(), t1.getTotalPrice());          
    }

}
