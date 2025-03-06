package com.example.seckill.vo;

import com.example.seckill.util.ValidatorUtil;
import com.example.seckill.validator.IsMobile;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    /**
     * 判断是否校验成功
     * 如果是必填的，则直接校验，如果不是，则如果为空，通过校验
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required){
            return ValidatorUtil.isMobile(value);
        }else {
            if(value.isEmpty()){
                return true;
            }else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
