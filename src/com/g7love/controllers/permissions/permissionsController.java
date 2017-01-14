package com.g7love.controllers.permissions;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g7love.beans.permissions.UserBean;
import com.g7love.help.result;
import com.g7love.services.permissions.permissions;

@Controller
public class permissionsController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private permissions permissi;
	/**
	 * @author lizhengxiang
	 * @CreationTime 17.1.5
	 * 获取自己发表的动态和别人发表的动态
	 */
	@ResponseBody
	@RequestMapping("/permissions/login")
	public Map<String, Object> login(HttpServletRequest req){
		Map u = permissi.login("100", "20");
		result<Map> restult = new result<Map>(u, 0,0);
		return restult.getRestult();
	}
	
	

}
