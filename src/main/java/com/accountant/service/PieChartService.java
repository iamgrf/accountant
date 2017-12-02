package com.accountant.service;

import com.accountant.domain.PieChartDomain;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/29.
 */
public class PieChartService {

    private PieChartDomain pieChartDomain = new PieChartDomain();

    public List<Map<String, Object>> typeStatistics(String startDate, String endDate){
        return pieChartDomain.typeStatistics(startDate, endDate);
    }

    public List<Map<String, Object>> mustStatistics(String startDate, String endDate){
        return pieChartDomain.mustStatistics(startDate, endDate);
    }

    public List<Map<String, Object>> notMustStatistics(String startDate, String endDate){
        return pieChartDomain.notMustStatistics(startDate, endDate);
    }

}
