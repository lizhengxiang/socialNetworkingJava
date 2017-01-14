package com.g7love.mappers.dynamic;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.g7love.beans.dynamic.getdynamicArgs;

public interface DynamicMapper {
	public ArrayList<Map> getDynamic(@Param("getdynamic")getdynamicArgs getdynamic);
}
