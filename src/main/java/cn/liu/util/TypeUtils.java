package cn.liu.util;

public class TypeUtils {
	/**
	 * @Description: 字符串转数字   
	 * @author liu
	 * @version 2019 年 03 月 14 日  11:27:12 
	 * @param str
	 * @return
	 */
	public static int strToInt(String str) {
		return Integer.parseInt(str);
	}
	/**
	 * @Description: object转数字   
	 * @author liu
	 * @version 2019 年 03 月 14 日  11:27:12 
	 * @param str
	 * @return
	 */
	public static int objToInt(Object obj) {
		return strToInt((String)obj);
	}
}
