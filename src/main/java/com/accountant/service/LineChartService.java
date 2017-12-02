package com.accountant.service;

import com.accountant.domain.LineChartDomain;
import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/29.
 */
public class LineChartService {

    private LineChartDomain lineChartDomain = new LineChartDomain();

    public List<Map<String, Object>> yStatistics(String startDate, String endDate){
        return lineChartDomain.yStatistics(startDate, endDate);
    }

    public List<Map<String, Object>> mStatistics(String startDate, String endDate){
        return lineChartDomain.mStatistics(startDate, endDate);
    }

    public List<Map<String, Object>> dStatistics(String startDate, String endDate){
        return lineChartDomain.dStatistics(startDate, endDate);
    }

}
