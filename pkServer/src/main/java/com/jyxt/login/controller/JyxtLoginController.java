package com.jyxt.login.controller;

import com.jyxt.login.service.JyxtLoginService;
import com.jyxt.utils.TableNameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@Controller
@RequestMapping("v1/login/")
public class JyxtLoginController {
    private Logger logger = Logger.getLogger(JyxtLoginController.class);
    @Autowired
    JyxtLoginService jyxtindexservice;

    @RequestMapping(value = "/get")
    @ResponseBody
    public Map cloumn(@RequestParam(value = "name", required = true) String name,
                      @RequestParam(value = "password", required = true) String password,
                      HttpSession session) {
        Map<String, Object> resultMp = new HashMap<>();
        try {
            int re = jyxtindexservice.login(name, password, session);
            resultMp.put("jsonData", re);
        } catch (Exception e) {
            //后续追加日志处理功能
            logger.error("控制层异常", e);
            resultMp.put("errorMsg", "服务器异常");
            resultMp.put("httpStatus", "500");
        }
        return resultMp;
    }


}
