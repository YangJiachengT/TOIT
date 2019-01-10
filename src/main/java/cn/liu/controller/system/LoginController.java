package cn.liu.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.liu.constant.AppConstant;
import cn.liu.service.system.LoginServiceImpl;
import cn.liu.util.SessionUtils;
import cn.liu.util.bean.Ret;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired LoginServiceImpl loginServiceImpl;
	@RequestMapping("")
	public ModelAndView login(@RequestParam String username,@RequestParam String password,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Ret ret = loginServiceImpl.login(username,password,request);
		if(ret.isOk()) {
			mv.setViewName("/admin/home");
		}else {
			mv.setViewName("login");
			mv.addObject("Message", ret.getMessage());
		}
		return mv;
	}
}
