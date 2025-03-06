package com.example.seckill.vo;

import com.example.seckill.validator.IsMobile;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginVo {
    @IsMobile
    private String mobile;

    @Length(min = 32)
    private String password;

}
