package cn.liu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	/**
	 * 
	 * @Description: md5加密    
	 * @author liu
	 * @version 2018 年 12 月 06 日  11:25:11 
	 * @param inStr
	 * @return 加密后的字符串
	 */
	public static String getStrMD5(String inStr) {
		// 获取MD5实例
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return "";
		}
 
		// 将加密字符串转换为字符数组
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
 
		// 开始加密
		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] digest = md5.digest(byteArray);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digest.length; i++) {
			int var = digest[i] & 0xff;
			if (var < 16)
				sb.append("0");
			sb.append(Integer.toHexString(var));
		}
		return sb.toString();
	}
}
