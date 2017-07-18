package com.jyxt.index.service;

import java.util.List;
import java.util.Map;
public interface JyxtIndexService {
    /**
     * 过自定义sql查询数据返回list集合，数据已MAP形式保存其中
     * @param data
     * @return
     */
    List<Map<String,Object>> queryBySql(Map<String,String> data);

    /**
     *  查询表中列的说明
     * @param schema
     * @param table
     * @return
     */
    List<Map<String,String>> queryCloumnName(String schema,String table);

    /**
     * 对表进行批量新增
     * @param tableName
     * @param jsonData
     * @return
     */
    int insertByTableName(String tableName,String jsonData);
}
