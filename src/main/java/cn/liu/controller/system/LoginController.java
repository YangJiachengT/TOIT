package cn.liu.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.liu.service.system.LoginServiceImpl;
import cn.liu.util.bean.Ret;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired LoginServiceImpl loginServiceImpl;
	
	@RequestMapping("")
	public Ret doLogin(@RequestParam String username,@RequestParam String password,HttpServletRequest request) {
		Ret ret = loginServiceImpl.login(username,password,request);
		return ret;
	}
}
