package com.william.exception;

import com.william.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther:xuxitan
 * @Date: 2018/12/3 15:29
 * @Description:
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        Result result = new Result();

        //自定义异常
        if(e instanceof CustomException){
            CustomException customException = (CustomException) e;
            result.setCode(customException.getCode());
            result.setMessage(customException.getMessage());
            return result;
        }

        result.setCode("000000");
        result.setMessage("系统异常,请稍后再试");

        return result;
    }
}
