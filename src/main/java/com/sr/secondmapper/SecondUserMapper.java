package com.sr.secondmapper;

import com.sr.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SecondUserMapper {
	public User queryList(@Param("username") String username, @Param("password") String password);

}
