package com.g7love.services.impl.dynamic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import javax.xml.crypto.Data;
import org.springframework.stereotype.Service;
import com.g7love.beans.dynamic.getdynamicArgs;
import com.g7love.help.result;
import com.g7love.mappers.dynamic.DynamicMapper;
import com.g7love.services.dynamic.dynamicService;
import com.g7love.help.tools;
@Service //注重业务层
public class dynamicServiceimpl implements dynamicService{
	@Resource //数据层
	private DynamicMapper um;
	@Override  //表示重写父类
	/*
     * 获取自己发表的动态和别人发表的动态
     * 获取当前用户的动态内容及点赞次数，转发次数，举报次数,也可以更具ｉｄ取出对应的说说
     * @todo 获取当前用户的头像等信息，看看会不会影响速度
     */
	public ArrayList<Map> searchDynamic(getdynamicArgs getdynamic) {
		ArrayList<Map> result =  um.getDynamic(getdynamic);
		/*
         * 这里需要处理该用户有没有登陆判断有没有对动态操作AND动态发表离当前时间
         * @todo 计算时间有可能会耗时，dai观察看看会不会影响速度
         */
		
		/*int len = result.size();
		Date createtime,currentTime = new Date();
		String dateString;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		tools tools = new tools();
		for (int i = 0; i < len; i++) {
			try  
			{  
				//dateString = result.get(i).get("createtime");  
				createtime = sdf.parse(dateString);  
				System.out.println(tools.timeDifference(createtime, currentTime));
				tools.timeDifference(createtime, currentTime);
			}  
			catch (ParseException e)  
			{  
			    System.out.println(e.getMessage());  
			}  
		}*/
		return result;
	}
}
