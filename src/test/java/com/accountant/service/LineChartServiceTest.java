package com.accountant.service;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/30.
 */
public class LineChartServiceTest {

    @Test
    public void yStatistics(){
        LineChartService lineChartService = new LineChartService();
        List<Map<String, Object>> c = lineChartService.yStatistics("2017-01-01", "2017-12-29");
        System.out.println(c);
    }

    @Test
    public void mStatistics(){
        LineChartService lineChartService = new LineChartService();
        List<Map<String, Object>> c = lineChartService.mStatistics("2017-01-01", "2017-12-29");
        System.out.println(c);
    }

    @Test
    public void dStatistics(){
        LineChartService lineChartService = new LineChartService();
        List<Map<String, Object>> c = lineChartService.dStatistics("2017-01-01", "2017-12-29");
        System.out.println(c);
    }

}
