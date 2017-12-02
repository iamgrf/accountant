package com.accountant.service;

import com.accountant.domain.ConsumeDomain;
import com.accountant.pojo.po.ConsumePO;
import com.accountant.util.DateUtil;
import com.accountant.util.PageUtil;
import com.accountant.util.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/10.
 */
public class ConsumeService {

    private ConsumeDomain consumeDomain = new ConsumeDomain();

    public Map<String, Object> add(ConsumePO consumePO){
        consumePO.setCreateDate(DateUtil.currentDateTime());
        Integer b = consumeDomain.save(consumePO);
        return ResultUtil.successful();
    }

    public Map<String,Object> list(PageUtil pageUtil) {
        consumeDomain.list(pageUtil);
        return ResultUtil.successful(pageUtil);
    }
}
