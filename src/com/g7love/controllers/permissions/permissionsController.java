package com.g7love.controllers.permissions;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import redis.clients.jedis.Jedis;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g7love.beans.permissions.UserBean;
import com.g7love.help.result;
import com.g7love.redis.RedisService;
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
	public Map<String, Object> login(HttpServletRequest req,HttpServletResponse response,HttpSession httpSession,HttpSession session){
		int u = permissi.login("2011312050", "521521");
		session.setAttribute("username", "100");
		result<Integer> restult = new result<Integer>(u, 0,0);
		
		 //这里已经配置好,属于一个redis的服务接口
        //RedisService redisService = new RedisService();
        /*redisService.set("name", "lizhengxiang");*/
        
        /*String ping = redisService.ping();//测试是否连接成功,连接成功输出PONG
        System.out.println(ping);*/
        
		/*Jedis jedis = new Jedis("127.0.0.1");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);*/
		return restult.getRestult();
	}	
	
}
