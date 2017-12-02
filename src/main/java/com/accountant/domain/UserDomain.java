package com.accountant.domain;

import com.accountant.db.Db;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/10.
 */
public class UserDomain {

    public List<Map<String, Object>> login(String account, String pwd) {
        return Db.list("select * from t_user where account = ? and pwd = ?", account, pwd);
    }
}
