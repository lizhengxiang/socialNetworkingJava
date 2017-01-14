package com.g7love.services.dynamic;

import java.util.ArrayList;
import java.util.Map;

import com.g7love.beans.dynamic.getdynamicArgs;


public interface dynamicService {
	/*
     * 获取自己发表的动态和别人发表的动态
     * 获取当前用户的动态内容及点赞次数，转发次数，举报次数,也可以更具ｉｄ取出对应的说说
     * @todo 获取当前用户的头像等信息，看看会不会影响速度
     */
	public ArrayList<Map> searchDynamic(getdynamicArgs getdynamic);
}
