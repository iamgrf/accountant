package com.accountant.util;

/**
 * Created by xy on 2017/5/11.
 */
public enum ResultMsgEnum {

    FAIL(0, "操作失败"),
    SUCCESSFUL(1, "操作成功"),
    ERROR_USER_PWD(10001, "用户名或密码有误"),
    ERROR_PARAM(10002, "请完善信息"),
    ERROR_DISABLE(10003, "你已被禁用，请联系管理员"),
    ERROR_USER_EXIST(10004, "用户已存在"),
    ERROR_DATA_EXIST(10005, "数据已存在"),
    ERROR_DISACCESS(10006, "没有权限"),
    ERROR_RELOGIN(10007, "重新登录"),
    ERROR_DEPENDENT(10008, "数据被依赖"),
    ERROR_OLDPASSWORD(10009, "旧密码误"),
    ERROR_DECODE(10010, "解码失败"),
    ERROR_DEVICE_EXIST(10011, "设备已存在"),
    ERROR_NOT_CHANNEL(10012, "你没有此渠道"),
    ERROR_AUS_NOT_HAVE(10013, "鉴权系统没有此信息"),
    ERROR_UNIQE(10014, "数据不唯一, 无法出库");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultMsgEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
