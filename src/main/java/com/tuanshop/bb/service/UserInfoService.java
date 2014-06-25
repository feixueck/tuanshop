package com.tuanshop.bb.service;

import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.pojo.UserInfoDomain;

public interface UserInfoService {
	Long add(UserInfoDomain user);

	UserInfoDomain findId(Long id);

	void update(UserInfoDomain user);

	void delete(Long id);

	UserQuery<UserInfoDomain> queryUserInfoPageList(
			UserQuery<UserInfoDomain> query);

	UserInfoDomain findUserByNameAndPasswd(String username, String password);
}
