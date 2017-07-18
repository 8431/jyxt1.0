package com.jyxt.index.controller;

import com.jyxt.admin.controller.Cocos2dHxsgAdminController;
import com.jyxt.index.service.JyxtIndexService;
import com.jyxt.utils.TableNameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@Controller
@RequestMapping("v1/index/")
public class JyxtIndexController {
    private Logger logger = Logger.getLogger(JyxtIndexController.class);
    @Autowired
    JyxtIndexService jyxtindexservice;

    @RequestMapping(value = "/cloumn/get")
    @ResponseBody
    public Map cloumn(@RequestParam(value = "tableName", required = true) String tableName) {
        List<Map<String, String>> liCloumn = null;
        Map<String, Object> resultMp = new HashMap<>();
        try {
            liCloumn = jyxtindexservice.queryCloumnName(TableNameUtils.SCHEMA, tableName);
            resultMp.put("jsonData", liCloumn);
        } catch (Exception e) {
            //后续追加日志处理功能
            logger.error("控制层异常", e);
            resultMp.put("errorMsg", "服务器异常");
            resultMp.put("httpStatus", "500");
        }
        return resultMp;
    }

    /**
     * 批量新增
     *
     * @param tableName
     * @param jsonData
     * @return
     */
    @RequestMapping(value = "/cloumn/insert")
    @ResponseBody
    public Map insertJsonData(@RequestParam(value = "tableName", required = true) String tableName,
                              @RequestParam(value = "jsonData", required = true) String jsonData) {
        Map<String, Object> resultMp = new HashMap<>();
        try {
            int result = jyxtindexservice.insertByTableName(tableName, jsonData);
            resultMp.put("jsonData", result);
        } catch (Exception e) {
            //后续追加日志处理功能
            logger.error("控制层异常", e);
            resultMp.put("errorMsg", "服务器异常");
            resultMp.put("httpStatus", "500");
        }
        return resultMp;
    }
//    @RequestMapping(value = "/insert")
//    @ResponseBody
//    public ResultVo  getData(@RequestParam(value="tableName", required=true) String tableName,
//                                             @RequestParam(value="jsonData", required=true) String jsonData){
//        List<Map<String,String>> liCloumn=null;
//        try{
//            liCloumn=jyxtindexservice.insertByTableName(tableName,jsonData);
//        }catch (Exception e){
//            logger.error("控制层异常",e);
//        }
//        return   liCloumn;
//    }


}
