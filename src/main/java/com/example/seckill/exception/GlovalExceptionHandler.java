package com.example.seckill.exception;

import com.example.seckill.vo.RespBean;
import com.example.seckill.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlovalExceptionHandler {
    /**
     * 全局异常处理器
     * MethodArgumentNotValidException目前已经是BindException的子类，所以也可以使用BindException来处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public RespBean handleException(Exception e) {

        System.out.println("异常为"+e);

        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return RespBean.error(globalException.getRespBeanEnum());
        } else if (e instanceof BindException ex) {
            StringBuilder sb = new StringBuilder();
            ex.getBindingResult().getAllErrors().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                sb.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append("; ");
            });
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
            respBean.setMessage("参数校验异常：" + sb.toString());
            return respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}