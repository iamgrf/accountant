package com.accountant.domain;

import com.accountant.db.Db;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/9.
 */
public class TypeDomain {

    public Integer save(String v, String name){
        return Db.insert("insert into t_type(v, name) values ('"+ v +"', '"+ name +"')");
    }

    public Integer delete(Integer id){
        return Db.delete("delete from t_type where id=" + id);
    }

    public List<Map<String, Object>> list(String v){
        return Db.list("select * from t_type where v = ?", v);
    }

}
