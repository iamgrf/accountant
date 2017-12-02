package com.accountant.domain;

import com.accountant.db.Db;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/29.
 */
public class PieChartDomain {

    public List<Map<String, Object>> typeStatistics(String startDate, String endDate){
        String sql = "SELECT sum(amount) as totalAmount, v as name FROM t_consume, t_type where t_consume.type_id = t_type.id and consume_date>=? and consume_date<=? group by v";
        return Db.list(sql, startDate, endDate);
    }

    public List<Map<String, Object>> mustStatistics(String startDate, String endDate){
        return statistics(startDate, endDate, "0");
    }

    public List<Map<String, Object>> notMustStatistics(String startDate, String endDate){
        return statistics(startDate, endDate, "1");
    }

    private List<Map<String, Object>> statistics(String startDate, String endDate, String v){
        String sql = "SELECT sum(amount) as totalAmount, name FROM t_consume, t_type where t_consume.type_id = t_type.id and consume_date>=? and consume_date<=? and v=? group by type_id";
        return Db.list(sql, startDate, endDate, v);
    }

}
