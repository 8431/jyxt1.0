package com.jyxt.utils;

/**
 * Created by Administrator on 2017/7/13.
 */
public enum HttpStatusEnum {
     S_200(200), S_201(201),S_300(300),S_500(500);
    private int value;

    private HttpStatusEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

}
