package com.g7love.help;

import java.text.SimpleDateFormat;
import java.util.Date;

public class tools {
	public String timeDifference(Date startTime,Date endTime){
		long timediff = endTime.getTime() - startTime.getTime();
		int days = (int)timediff/86400000 -1;
		String timeDifference;
		if(days>0){
			timeDifference = days +"天前";
		}else{
			int remain = (int)timediff%86400;
            int hours = (int)remain/3600;
            if(hours>0){
            	timeDifference = hours + "小时前";
            }else{
            	remain = (int)remain%3600;
                int mins = (int)remain/60;
                if(mins>0){
                	timeDifference = mins + "分钟前";
                }else{
                	timeDifference = remain + "秒前";
                }
            }
		}
		return timeDifference;
	}
}
