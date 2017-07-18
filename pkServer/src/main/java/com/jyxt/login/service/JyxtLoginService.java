package com.jyxt.login.service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface JyxtLoginService {
    /**
     * 登录系统
     * @param name
     * @param pass
     * @return
     */
   int login(String name, String pass, HttpSession session);
}
