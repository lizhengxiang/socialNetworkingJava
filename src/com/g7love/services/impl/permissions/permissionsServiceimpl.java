package com.g7love.services.impl.permissions;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.g7love.mappers.permissions.permissionsMapper;
import com.g7love.services.permissions.permissions;

@Service
public class permissionsServiceimpl implements permissions{
	@Resource //数据层
	private permissionsMapper permissions;
	
	@Override
	public Map login(String useName, String passworld){
		Map isLogin = permissions.login(useName, passworld);
		return isLogin;
	}

}
