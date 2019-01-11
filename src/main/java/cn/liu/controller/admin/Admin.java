package cn.liu.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.liu.constant.AppConstant;
import cn.liu.util.DbUtils;
import cn.liu.util.SessionUtils;
import cn.liu.util.bean.Record;

@RequestMapping("/admin")
@Controller
public class Admin {
	@RequestMapping("home")
	public ModelAndView adminHome(ModelAndView mv) {
		mv.setViewName("admin/home");
		mv.addObject("active", "home");
		return mv;
	}
	@RequestMapping("course/type")
	public ModelAndView courseType(ModelAndView mv) {
		mv.setViewName("admin/course/cou_type");
		mv.addObject("ACTIVE", "course/type");
		mv.addObject("F_ACTIVE", "course");
		return mv;
	}
	@RequestMapping("course/open")
	public ModelAndView courseOpen(ModelAndView mv,@RequestParam String couCode) {
		mv.setViewName("admin/course/cou_open");
		List<Record> teacherList = DbUtils.find(" select id,user_real_name from sys_user where user_type = '2' order by user_name");
		mv.addObject("course_code", couCode);
		mv.addObject("teacherList", teacherList);
		mv.addObject("ACTIVE", "course/type");
		mv.addObject("F_ACTIVE", "course");
		return mv;
	}
	@RequestMapping("course/base")
	public ModelAndView courseBase(ModelAndView mv,@RequestParam String couCode) {
		mv.setViewName("admin/course/cou_base");
		mv.addObject("course_code", couCode);
		mv.addObject("ACTIVE", "course/type");
		mv.addObject("F_ACTIVE", "course");
		return mv;
	}
	@RequestMapping("course/question")
	public ModelAndView coursequestion(ModelAndView mv) {
		mv.setViewName("admin/course/cou_question");
		return mv;
	}
	
	@RequestMapping("user")
	public ModelAndView adminUser(ModelAndView mv) {
		mv.setViewName("admin/user/sys_user");
		mv.addObject("F_ACTIVE", "user");
		return mv;
	}
	
	@RequestMapping("login")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("logout")
	public ModelAndView logout(ModelAndView mv,HttpSession session) {
		session.removeAttribute(AppConstant.SESSION_USER);
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("test")
	public ModelAndView test(ModelAndView mv) {
		mv.setViewName("test");
		return mv;
	}
}
