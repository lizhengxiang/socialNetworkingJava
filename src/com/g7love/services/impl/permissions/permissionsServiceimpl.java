package com.g7love.services.impl.permissions;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.g7love.interceptor.CommonInterceptor;
import com.g7love.mappers.permissions.permissionsMapper;
import com.g7love.services.permissions.permissions;

@Service
public class permissionsServiceimpl implements permissions{
	@Resource //数据层
	private permissionsMapper permissions;
	
	@Override
	public int login(String useName, String passworld){
		Map isLogin = permissions.login(useName, passworld);
		if(isLogin.get("id") != null){
			System.out.println(isLogin.get("userid"));
			System.out.println(CommonInterceptor.userid);
			
		}else {
			return 0;
		}
		return 1;
	}

}
