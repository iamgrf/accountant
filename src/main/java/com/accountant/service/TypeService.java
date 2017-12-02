package com.accountant.service;

import com.accountant.domain.TypeDomain;
import com.accountant.util.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/9.
 */
public class TypeService {

    private TypeDomain typeDomain = new TypeDomain();

    /**
     *
     * @param v 0必须1非必须
     * @param name
     * @return
     */
    public Map<String, Object> add(String v, String name) {
        Integer b = typeDomain.save(v, name);
        if (b > 0){
            return ResultUtil.successful();
        }
        return ResultUtil.fail();
    }

    public Map<String, Object> delete(Integer id) {
        Integer b = typeDomain.delete(id);
        if (b > 0){
            return ResultUtil.successful();
        }
        return ResultUtil.fail();
    }

    public Map<String, Object> list(String v) {
        List<Map<String, Object>> result = typeDomain.list(v);
        return ResultUtil.successful(result);
    }

}
