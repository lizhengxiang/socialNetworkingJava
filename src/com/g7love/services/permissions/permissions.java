package com.g7love.services.permissions;

import java.util.Map;

import org.springframework.stereotype.Service;
public interface permissions {
	/**
	 * 用户登陆
	 */
	public  Map login(String useName, String passworld);
	
}
