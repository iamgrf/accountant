package com.accountant.service;

import com.accountant.domain.UserDomain;
import com.accountant.util.ResultMsgEnum;
import com.accountant.util.ResultUtil;
import com.accountant.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/10.
 */
public class UserService {

    private UserDomain userDomain = new UserDomain();

    public Map<String, Object> login(String account, String pwd){
        List<Map<String, Object>> result = userDomain.login(account, pwd);
        if (result != null && result.size() > 0){
            return ResultUtil.successful(result.get(0));
        }
        return ResultUtil.fail(ResultMsgEnum.ERROR_USER_PWD);
    }

}
