package cn.wildMeowth.bookSeats.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {

	private static final String salt = "Äã³ÔÁËÂğ£¿";
	
	public static String crypt(String pwd){
		return DigestUtils.md5Hex(pwd+salt);
	}
}
