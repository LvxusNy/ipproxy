package com.lvxus.ipproxy;

import com.lvxus.ipproxy.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
public class CommitTest {

    @Test
    public void get_how_many_day_from_this_day_to_Sunday() {
        Date date = new Date("2019/11/20");
        int Sunday_in_this_week = DateUtils.getHowManyDayFromThisDayToSunday(date);
        Assert.assertEquals(4, Sunday_in_this_week);
    }


    @Test
    public void judge_the_day_pass_a_week_test() {
        Date date = new Date("2019/11/20");
        long theJudge = DateUtils.getJudgeTheDayPassOneWeek(date);
        long thePassTime = theJudge/7;
        Assert.assertEquals(1,thePassTime );
    }

}
