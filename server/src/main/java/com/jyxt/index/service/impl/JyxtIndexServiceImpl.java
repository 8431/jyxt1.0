package com.jyxt.index.service.impl;

import com.google.gson.Gson;
import com.jyxt.Dao.IHxsgBaseDao;
import com.jyxt.Dao.IndexDao;
import com.jyxt.index.controller.JyxtIndexController;
import com.jyxt.index.service.JyxtIndexService;
import com.jyxt.utils.TableNameUtils;
import com.jyxt.vo.ColumnAndComment;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.management.RuntimeErrorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2016/10/14.
 */
@Service("JyxtIndexService")
public class JyxtIndexServiceImpl implements JyxtIndexService {
    private Logger logger = Logger.getLogger(JyxtIndexServiceImpl.class);
    @Autowired
    IndexDao indexdao;
    @Override
    public List<Map<String, Object>> queryBySql(Map<String, String> data) {

        return indexdao.queryBySql(data);
    }
    @Override
    public List<Map<String,String>> queryCloumnName(String schema, String table) {
        List<Map<String,String>> mp=null;
        try {
            if (!StringUtils.isEmpty(schema) && !StringUtils.isEmpty(table)) {
                //校验表名是否向外开放
                Boolean re=TableNameUtils.checkTableName(table);
                if(re)
                    mp=indexdao.queryCloumnName(schema, table);
            } else {
                logger.error("查询列名的时候，schema和table都不能为空");
            }
        } catch (Exception e) {
            logger.error("queryCloumnName方法查询异常",e);

        }
        return mp;
    }

    @Override
    public int insertByTableName(String tableName,String jsonData) {
        Gson gn=new Gson();
        Map sql=new HashMap();
        List result=gn.fromJson(jsonData,List.class);
        sql.put("tablename",tableName);
        sql.put("jsonData",result);
        int re=indexdao.insertByTableName(sql);

        return re;
    }

}
