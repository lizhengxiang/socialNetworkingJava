package com.g7love.help;

import java.text.SimpleDateFormat;
import java.util.Date;

public class tools {
	public String timeDifference(Date startTime,Date endTime){
		long timediff = endTime.getTime() - startTime.getTime();
		System.out.println(endTime.getTime());
		System.out.println(startTime.getTime());
		int days = (int)timediff/86400;
		String timeDifference;
		if(days>0){
			timeDifference = days +"天";
		}else{
			int remain = (int)timediff%86400;
            int hours = (int)remain/3600;
            if(hours>0){
            	timeDifference = hours + "小时";
            }else{
            	remain = (int)remain%3600;
                int mins = (int)remain/60;
                if(mins>0){
                	timeDifference = mins + "分钟";
                }else{
                	timeDifference = remain + "秒";
                }
            }
		}
		return timeDifference;
	}
}
