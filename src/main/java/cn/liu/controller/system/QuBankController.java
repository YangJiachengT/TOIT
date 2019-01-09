package cn.liu.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.liu.service.system.QuBankServiceImpl;
import cn.liu.util.bean.Ret;

/**
 * 题库
 * @author liu
 */
@Controller
@RequestMapping("/qubank")
public class QuBankController {
	@Autowired QuBankServiceImpl quBankServiceImpl;
	@RequestMapping("/dltemplate")
	public Ret dlTemplate(HttpServletResponse response,HttpServletRequest request) {
		quBankServiceImpl.dlTemplate(response, request);
		return null;
	}
}
