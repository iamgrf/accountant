package com.accountant.domain;

import com.accountant.db.Db;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/29.
 */
public class LineChartDomain {

    public List<Map<String, Object>> yStatistics(String startDate, String endDate) {
        return statistics(startDate, endDate, "%Y");
    }

    public List<Map<String, Object>> mStatistics(String startDate, String endDate) {
        return statistics(startDate, endDate, "%Y-%m");
    }

    public List<Map<String, Object>> dStatistics(String startDate, String endDate) {
        return statistics(startDate, endDate, "%Y-%m-%d");
    }

    private List<Map<String, Object>> statistics(String startDate, String endDate, String ymd){
        String sql = "SELECT sum(amount) totalAmount, strftime(?, consume_date) consumeDate FROM t_consume where consume_date>=? and consume_date<=? group by strftime(?, consume_date)";
        return Db.list(sql, ymd, startDate, endDate, ymd);
    }
}
