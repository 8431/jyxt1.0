package com.jyxt.utils;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
public class TableNameUtils {

    public static final Map<String,String> TABLENAME=new HashMap<String,String>();
    public static final String SCHEMA="jyxt";
    static{
        TABLENAME.put("cjxq","cjxq");

    }
    public static Boolean checkTableName(String name){
        Boolean result=false;
        if(!StringUtils.isEmpty(TableNameUtils.TABLENAME.get(name))){
            result=true;
        }
            return result;
    }
}
