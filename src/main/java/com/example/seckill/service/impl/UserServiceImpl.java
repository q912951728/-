package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.exception.GlobalException;
import com.example.seckill.mapper.UserMapper;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import com.example.seckill.util.MD5Util;
import com.example.seckill.util.ValidatorUtil;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;
import com.example.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  服务实现类
 * </p>
*  张是小
* @author zsx
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    private static final Pattern mobile_pattern = Pattern.compile("[1]([3-9])[0-9]{9}$");


    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param loginVo
     * @return
     */
    @Override
    public RespBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

//        if(mobile == null || password == null || mobile.isEmpty() || password.isEmpty()){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
//        }
//        if(!ValidatorUtil.isMobile(mobile)){
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }
        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if(user == null){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //判断密码是否正确
        if (!MD5Util.formPassToDBPass(password,user.getSlat()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }

        return RespBean.success();
    }
}
