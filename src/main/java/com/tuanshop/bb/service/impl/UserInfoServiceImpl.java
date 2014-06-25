package com.tuanshop.bb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.UserInfoDao;
import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.pojo.UserInfoDomain;
import com.tuanshop.bb.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public Long add(UserInfoDomain user) {
		return userInfoDao.addUser(user);
	}

	@Override
	public UserInfoDomain findId(Long id) {
		return userInfoDao.findId(id);
	}

	@Override
	public UserQuery<UserInfoDomain> queryUserInfoPageList(
			UserQuery<UserInfoDomain> query) {
		return userInfoDao.findUserPageList(query);
	}

	@Override
	public void update(UserInfoDomain user) {
		userInfoDao.update(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userInfoDao.delete(id);
	}

	@Override
	public UserInfoDomain findUserByNameAndPasswd(String username,
			String password) {

		return userInfoDao.findUserByNameAndPasswd(username, password);
	}

}
