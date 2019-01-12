package cn.liu.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.hutool.db.DbUtil;
import cn.liu.constant.AppConstant;
import cn.liu.service.system.LoginServiceImpl;
import cn.liu.util.DbUtils;
import cn.liu.util.SessionUtils;
import cn.liu.util.bean.Record;
import cn.liu.util.bean.Ret;

@RestController
@RequestMapping("/log")
public class LogController {
	@RequestMapping("")
	public List<Record> login() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT l.*,u.user_real_name FROM sys_log l ");
		sql.append("  LEFT JOIN sys_user u ON u.id = l.user_id");
		return DbUtils.find(sql.toString());
	}
}
