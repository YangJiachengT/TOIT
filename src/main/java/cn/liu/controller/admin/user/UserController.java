package cn.liu.controller.admin.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.liu.po.User;
import cn.liu.service.user.UserServiceImpl;
import cn.liu.util.DateUtil;
import cn.liu.util.bean.Record;
import cn.liu.util.bean.Ret;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired UserServiceImpl userServiceImpl;
	@RequestMapping("userList")
	public List<Record> userList(){
		List<Record> list = userServiceImpl.getUserList();
		for (Record record : list) {
			record.put("create_date", DateUtil.dateToStr((Date)record.get("create_date")));
			record.put("lastest_login_time", DateUtil.dateToStr((Date)record.get("lastest_login_time")));
			
			switch (Integer.parseInt((String) record.get("user_type"))) {
			case 0:
				record.put("user_type", "超级管理员");
				break;
			case 2:
				record.put("user_type", "教师");
				break;
			default:record.put("user_type", "学生");
				break;
			}
		}
		return list;
	}
	@RequestMapping("userAdd")
	public Ret courseAdd(@RequestBody HashMap<String, Object> map){
		return userServiceImpl.addUser(map);
	}
	@RequestMapping("userDelete")
	public Ret courseDelete(@RequestBody String id){
		return userServiceImpl.deleteUser(id);
	}
	@RequestMapping("userResetPwd")
	public Ret userResetPwd(@RequestBody String id){
		return userServiceImpl.resetUserPwd(id);
	}
}
