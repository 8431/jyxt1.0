package com.jyxt.aop;

import com.jyxt.utils.HttpStatusEnum;
import com.jyxt.utils.ResultVo;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service("testaop")
public class AopController {

    public void beforeController(){
        System.out.println("------------------------------");
    }
    public void afterController(JoinPoint joinPoint, Object retValue){
        Map<String,Object> resultMp= (Map<String, Object>) retValue;
        if(resultMp.get("jsonData")!=null){
            resultMp.put("msg","succes");
            resultMp.put("httpStatus", HttpStatusEnum.S_200.getValue());
        }else{
            if(resultMp.get("httpStatus")==null){
                resultMp.put("httpStatus", HttpStatusEnum.S_201.getValue());
            }
            resultMp.put("msg","fail");
        }
    }
}
