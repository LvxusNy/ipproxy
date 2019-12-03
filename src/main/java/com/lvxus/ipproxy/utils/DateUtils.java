package com.lvxus.ipproxy.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static long getJudgeTheDayPassOneWeek(Date date) {
        long theDateTime = date.getTime();
        int theDayFromThisDayToSunday = getHowManyDayFromThisDayToSunday(date);
        long time = theDayFromThisDayToSunday * 24 * 3600 * 1000;
        Date nowDate = Calendar.getInstance().getTime();
        long nowTime = nowDate.getTime();
        return (nowTime - (theDateTime + time)) / (24 * 3600 * 1000);
    }
    public static int getHowManyDayFromThisDayToSunday(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int week_of_today = instance.get(Calendar.DAY_OF_WEEK) - 1;
        return (7 - week_of_today);
    }

}
