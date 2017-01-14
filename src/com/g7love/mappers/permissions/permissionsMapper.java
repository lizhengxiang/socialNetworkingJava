package com.g7love.mappers.permissions;

import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface permissionsMapper {
	public Map login(@Param("username")String username,@Param("password")String password);
}
