package com.jyxt.login.service.impl;

import com.google.gson.Gson;
import com.jyxt.Dao.IndexDao;
import com.jyxt.login.service.JyxtLoginService;
import com.jyxt.utils.TableNameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2016/10/14.
 */
@Service("JyxtLoginService")
public class JyxtLoginServiceImpl implements JyxtLoginService {
    @Autowired
    IndexDao indexdao;
    @Override
    public int login(String name, String pass, HttpSession session) {
        int result=0;
        if(!StringUtils.isEmpty(name)&&!StringUtils.isEmpty(pass)){
            name=name.trim();
            pass=pass.trim();
        }
        String sql="select * from login where name=#{0,jdbcType=VARCHAR} and password=#{1,jdbcType=VARCHAR}";
        Map sqlMp=new HashMap();
        sqlMp.put("sql",sql);
        sqlMp.put("name",name);
        sqlMp.put("pass",pass);
        List re=indexdao.queryBySql(sqlMp);
        if(re!=null&&re.size()==1){
            result=re.size();
            Map  reMp= (Map) re.get(0);
            session.setAttribute("loginKey",reMp);
        }
        return result;
    }
}
