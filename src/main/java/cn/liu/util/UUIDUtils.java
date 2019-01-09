package cn.liu.util;

import java.util.UUID;

public class UUIDUtils {
	public static String UUID2Str() {
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}
}
