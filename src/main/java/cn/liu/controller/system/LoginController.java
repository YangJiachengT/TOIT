package cn.liu.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.liu.service.system.LoginServiceImpl;
import cn.liu.util.bean.Ret;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired LoginServiceImpl loginServiceImpl;
	@RequestMapping("")
	public ModelAndView login(@RequestParam String username,@RequestParam String password) {
		ModelAndView mv = new ModelAndView();
		Ret ret = loginServiceImpl.login(username,password);
		if(ret.isOk()) {
			mv.setViewName("/admin/home");
		}else {
			mv.setViewName("login");
			mv.addObject("Message", ret.getMessage());
		}
		return mv;
	}
}
