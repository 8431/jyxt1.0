package com.jyxt.Dao;

import com.jyxt.po.Login;

public interface LoginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbggenerated Mon Jul 17 16:50:23 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbggenerated Mon Jul 17 16:50:23 CST 2017
     */
    int insert(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbggenerated Mon Jul 17 16:50:23 CST 2017
     */
    int insertSelective(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbggenerated Mon Jul 17 16:50:23 CST 2017
     */
    Login selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbggenerated Mon Jul 17 16:50:23 CST 2017
     */
    int updateByPrimaryKeySelective(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbggenerated Mon Jul 17 16:50:23 CST 2017
     */
    int updateByPrimaryKey(Login record);
}