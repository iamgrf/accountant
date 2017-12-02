package com.accountant.util;

import java.util.HashMap;

/**
 * 组装客户端信息
 * Created by xy on 2017/5/11.
 */
public class ResultUtil {

    public static java.util.Map<String, Object> fail(){

        java.util.Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("code", ResultMsgEnum.FAIL.getCode());
        msgMap.put("msg", ResultMsgEnum.FAIL.getMsg());
        return msgMap;

    }

    public static java.util.Map<String, Object> fail(String msg){

        java.util.Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("code", ResultMsgEnum.FAIL.getCode());
        msgMap.put("msg", msg);
        return msgMap;

    }

    public static java.util.Map<String, Object> fail(ResultMsgEnum error){

        java.util.Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("code", error.getCode());
        msgMap.put("msg", error.getMsg());
        return msgMap;

    }


    public static java.util.Map<String, Object> successful(){

        java.util.Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("code", ResultMsgEnum.SUCCESSFUL.getCode());
        msgMap.put("msg", ResultMsgEnum.SUCCESSFUL.getMsg());
        return msgMap;

    }

    public static java.util.Map<String, Object> successful(Object data){
        java.util.Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("code", ResultMsgEnum.SUCCESSFUL.getCode());
        msgMap.put("msg", ResultMsgEnum.SUCCESSFUL.getMsg());
        msgMap.put("data", data);
        return msgMap;

    }


}
