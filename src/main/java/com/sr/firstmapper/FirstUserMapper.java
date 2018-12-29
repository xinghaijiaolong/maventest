package com.sr.firstmapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sr.model.User;

@Mapper
public interface FirstUserMapper {

	public User queryfirst(@Param("username") String username, @Param("password") String password);

}
