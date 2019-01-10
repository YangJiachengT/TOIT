package cn.liu.service.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liu.constant.AppConstant;
import cn.liu.mapper.UserMapper;
import cn.liu.po.User;
import cn.liu.po.UserExample;
import cn.liu.util.MD5Utils;
import cn.liu.util.SessionUtils;
import cn.liu.util.bean.Ret;

@Service
public class LoginServiceImpl {
	@Autowired UserMapper userMapper;
	
	public Ret login(String username, String password,HttpServletRequest request) {
		UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria(); //构造自定义查询条件
        criteria.andUserNameEqualTo(username);
        User user = userMapper.selectByExample(userExample).size() > 0
        				? userMapper.selectByExample(userExample).get(0)
        						: null;
        if(user != null) {
        	if(MD5Utils.getStrMD5(password + user.getPwdSalt()).equals(user.getUserPassword())) {
        		SessionUtils.setSession(AppConstant.SESSION_USER,user, request);
        		return Ret.ok();
        	}
		}
		return Ret.fail().setMessage("用户名或密码错误");
	}
}
