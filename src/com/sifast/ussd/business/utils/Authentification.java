package com.sifast.ussd.business.utils;

import java.util.HashMap;

public class Authentification {
	
	private static HashMap<String, String> users = new HashMap<String, String>();
	
	static {
		users.put("admin", "admin");
		users.put("java", "java");
		users.put("ussd", "ussd");
		users.put("dongle", "dongle");
	}
	
	public static boolean authenticate(String username, String password) {
		String passwd = users.get(username);
		return password.equals(passwd);
	}

}
