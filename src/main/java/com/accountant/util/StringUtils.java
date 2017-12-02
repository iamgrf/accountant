package com.accountant.util;

public class StringUtils {

    public static Boolean isAnyEmpty(String ...args){
        if (args == null || args.length == 0){
            return true;
        }
        for (int i = 0; i < args.length; i++) {
            if (isEmpty(args[i])){
                return true;
            }
        }
        return false;
    }

    public static Boolean isEmpty(String args){
        if (args == null || args.trim().length() == 0){
            return true;
        }
        return false;
    }

    public static Boolean isAnyNotEmpty(String ...args){
        for (int i = 0; i < args.length; i++) {
            if (isNotEmpty(args[i])){
                return true;
            }
        }
        return false;
    }

    public static Boolean isNotEmpty(String args){
        if (args != null && args.trim().length() > 0){
            return true;
        }
        return false;
    }

    public static String objTOstr(Object obj){
        if (obj == null || isEmpty(String.valueOf(obj))){
            return "";
        }
        return String.valueOf(obj);

    }

}
