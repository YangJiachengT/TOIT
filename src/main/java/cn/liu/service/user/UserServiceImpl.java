package cn.liu.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.liu.constant.AppConstant;
import cn.liu.mapper.UserMapper;
import cn.liu.po.CouType;
import cn.liu.po.User;
import cn.liu.po.UserExample;
import cn.liu.util.DateUtil;
import cn.liu.util.DbUtils;
import cn.liu.util.MD5Utils;
import cn.liu.util.SessionUtils;
import cn.liu.util.UUIDUtils;
import cn.liu.util.aop.annotation.OperationLogDetail;
import cn.liu.util.aop.enums.OperationType;
import cn.liu.util.bean.Record;
import cn.liu.util.bean.Ret;

@Service
public class UserServiceImpl {
	@Autowired UserMapper userMapper;
	/**
	 * 
	 * @Description: 获取用户列表    
	 * @author liu
	 * @version 2018 年 12 月 19 日  13:53:51 
	 * @return
	 */
	public List<Record> getUserList(){
		String sql = " select * from sys_user order by user_name";
		return DbUtils.find(sql);
	}
	/**
	 * 
	 * @Description:添加用户    
	 * @author liu
	 * @version 2018 年 12 月 19 日  13:54:53 
	 * @param map
	 * @return
	 */
	@OperationLogDetail(detail = "添加用户",operationType = OperationType.INSERT)
	public Ret addUser(HashMap<String, Object> map) {
		String userName = (String) map.get("userName");
		String userType = (String) map.get("userType");
		//判断用户名是否存在
		UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria(); //构造自定义查询条件
        criteria.andUserNameEqualTo(userName);
        
		if(userMapper.selectByExample(userExample).size() > 0) {
			return Ret.fail().setMessage("用户已存在");
		}
		User user = new User();
		
		user.setUserName(userName);
		user.setUserType(userType);
		
		//UUID
		user.setId(UUIDUtils.UUID2Str());
		user.setCreateDate(DateUtil.currentDate());
		//密码盐
		Random rand = new Random();
		Integer salt = 100000 + rand.nextInt(900000);
		user.setPwdSalt(salt.toString());
		//加盐后的密码
		user.setUserPassword(MD5Utils.getStrMD5(AppConstant.DEFAULT_PASSWORD + salt.toString()));
		
		int state = userMapper.insert(user);
		if(state > 0) {
			return Ret.ok();
		}
		return Ret.fail().setMessage("用户添加失败");
	}
	/**
	 * 
	 * @Description: 删除用户    
	 * @author liu
	 * @version 2018 年 12 月 19 日  13:55:26 
	 * @param id
	 * @return
	 */
	@OperationLogDetail(detail = "删除用户",operationType = OperationType.DELETE)
	public Ret deleteUser(String id) {
		if(userMapper.deleteByPrimaryKey(id) > 0) {
			return Ret.ok();
		}
		return Ret.fail().setMessage("用户删除失败");
	}
	/**
	 * 重置密码
	 * @Description: 管理员重置用户密码    
	 * @author liu
	 * @version 2018 年 12 月 18 日  16:12:03 
	 * @param id
	 * @return
	 */
	public Ret resetUserPwd(String id) {
		User user =  userMapper.selectByPrimaryKey(id);
		String pwdSalt = user.getPwdSalt();
		user.setUserPassword(MD5Utils.getStrMD5(AppConstant.DEFAULT_PASSWORD + pwdSalt));
		if(userMapper.updateByPrimaryKey(user) > 0) {
			return Ret.ok();
		}
		return Ret.fail().setMessage("重置密码失败");
	}
}
