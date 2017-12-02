package com.accountant.domain;

import com.accountant.db.Db;
import com.accountant.pojo.po.ConsumePO;
import com.accountant.util.PageUtil;
import com.accountant.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/10.
 */
public class ConsumeDomain {

    public Integer save(ConsumePO consumePO){
        String sql = "insert into t_consume(type_id, user_id, item, amount, consumer, consume_date, consume_address, remark, create_date)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Db.insert(sql, consumePO.getTypeId(), consumePO.getUserId(), consumePO.getItem(), consumePO.getAmount()
                , consumePO.getConsumer(), consumePO.getConsumeDate(), consumePO.getConsumeAddress(), consumePO.getRemark(), consumePO.getCreateDate());
        return 0;
    }

    public PageUtil list(String startDate, String endDate, String type, PageUtil pageUtil){
        StringBuffer stringBuffer = new StringBuffer();
        if (StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)){
            stringBuffer.append("and consume_date >= '"+startDate + "' and consume_date <= '"+endDate+"'");
        }else if (StringUtils.isNotEmpty(startDate)){
            stringBuffer.append("and consume_date >= '"+startDate + "' and consume_date <= '"+startDate+"'");
        }else if (StringUtils.isNotEmpty(endDate)){
            stringBuffer.append("and consume_date >= '"+endDate + "' and consume_date <= '"+endDate+"'");
        }
        if (StringUtils.isNotEmpty(type)){
            stringBuffer.append("and t_type.v = "+type);
        }
        String sqlCount = "select count(1) as count from t_consume,t_type,t_user where t_consume.type_id = t_type.id and t_consume.user_id = t_user.id " + stringBuffer.toString();
        List<Map<String, Object>> total = Db.list(sqlCount);

        String sqlDate = "select t_type.v, t_type.name as type_name, t_user.real_name, t_consume.item, t_consume.number, t_consume.price, t_consume.amount, t_consume.consumer, " +
                "t_consume.consume_date, t_consume.consume_address, t_consume.remark, t_consume.create_date from t_consume,t_type,t_user where t_consume.type_id = t_type.id and t_consume.user_id = t_user.id "+stringBuffer.toString()+" order by t_consume.create_date desc limit "+ (pageUtil.getPage() * pageUtil.getPageSize()) +", " + pageUtil.getPageSize();
        List<Map<String, Object>> data = Db.list(sqlDate);

        pageUtil.setTotal(Integer.valueOf(String.valueOf(total.get(0).get("count"))));
        pageUtil.setData(data);
        return pageUtil;
    }

}
