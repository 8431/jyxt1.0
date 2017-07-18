package com.jyxt.Dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 * 增删改查接口
 */
public interface IndexDao {
    /**
     * 通过自定义sql查询数据返回list集合，数据已MAP形式保存其中
     * @param sqlMp
     * @return
     */
    List<Map<String,Object>> queryBySql(Map<String,String> sqlMp);
    /**
     * 查询表中列的说明
     * @param schema
     * @param table
     * @return
     */
    List<Map<String,String>> queryCloumnName(String schema,String table);

    /**
     * 对任意的表进行批量新增
     * @param data
     * @return
     */
    int insertByTableName(Map<String,Object> data);
}
