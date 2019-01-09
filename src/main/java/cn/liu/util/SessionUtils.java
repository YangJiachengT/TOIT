package cn.liu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static void setSession(String key,Object value,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute(key, value);
	}
	public static Object getSession(String key,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		return session.getAttribute(key);
	}
}
