package com.g7love.controllers.dynamic;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.g7love.beans.dynamic.getdynamicArgs;
import com.g7love.help.result;
import com.g7love.services.dynamic.dynamicService;

/**
 * @author lizhengxiang
 * @CreationTime 17.1.5
 */
@Controller
public class DynamicController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private dynamicService loginServiceImpl;
	/**
	 * @author lizhengxiang
	 * @CreationTime 17.1.5
	 * 获取自己发表的动态和别人发表的动态
	 */
	@ResponseBody
	@RequestMapping("/dynamic/getdynamic")
	public Map<String, Object> getdynamic(HttpServletRequest req,getdynamicArgs getdynamic){
		ArrayList<Map> u = loginServiceImpl.searchDynamic(getdynamic);
		result<ArrayList<Map>> restult = new result<ArrayList<Map>>(u, 0,0);
		return restult.getRestult();
	}
}
