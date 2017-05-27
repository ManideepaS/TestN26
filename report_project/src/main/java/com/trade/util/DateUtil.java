package com.trade.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static Calendar calculateSettlementDate(Date settlementDateInput, String currency){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Calendar settlementDate = Calendar.getInstance();
        try
        {
            
            settlementDate.setTime(settlementDateInput);
            int day = settlementDate.get(Calendar.DAY_OF_WEEK);
            
            if("AED".equals(currency) || "SAR".equals(currency))
            {
            	if (day == Calendar.FRIDAY)
                	settlementDate.add(Calendar.DATE, 2);
                if(day == Calendar.SATURDAY)
                	settlementDate.add(Calendar.DATE, 1);
            }else{
            	
                if (day == Calendar.SATURDAY)
                	settlementDate.add(Calendar.DATE, 2);
                if(day == Calendar.SUNDAY)
                	settlementDate.add(Calendar.DATE, 1);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return settlementDate;
    }
}
