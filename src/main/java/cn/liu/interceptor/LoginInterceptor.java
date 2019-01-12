package cn.liu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.liu.constant.AppConstant;

/**
 * 登录拦截器
 * @author liu
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	/**
	 * 视图渲染之后执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exc)
			throws Exception {
		
	}
	
	/**
	 * 在请求处理之后,视图渲染之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {
		if(response.getStatus() == 500) {
			response.sendRedirect("/html/500.html");
		}
	}

	/**
	 * 作用在控制器调用之前，返回值为true时执行下一个拦截器
	 * 
	 * 未登录则返回false
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		if(response.getStatus() == 404) {
			response.sendRedirect("/html/404.html");
			return false;
		}
		HttpSession session = request.getSession(true);
		Object user = session.getAttribute(AppConstant.SESSION_USER);
		//若session里存在user(即用户已登录)则进入目标控制器，反之将页面跳转到登录页
		if(user != null) {
			return true;
		}else {
			response.sendRedirect("/admin/login");//测试用，稍后修改为登录页 /system/login
			return false;
		}
	}

}
