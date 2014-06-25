package com.tuanshop.bb.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.UserInfoDao;
import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.pojo.UserInfoDomain;

@Repository
public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	public Long addUser(UserInfoDomain user) {
		System.out.println("save user:" + user.getUsername());
		getSqlMapClientTemplate().insert("userinfo.addUser", user);
		return System.currentTimeMillis();
	}

	public UserInfoDomain findId(Long id) {
		return (UserInfoDomain) getSqlMapClientTemplate().queryForObject(
				"userinfo.findUserById", id);
	}

	public UserQuery<UserInfoDomain> findUserPageList(
			UserQuery<UserInfoDomain> query) {
		return (UserQuery<UserInfoDomain>) listByQuery(
				"userinfo.list_by_query", query);

	}

	@Override
	public void update(UserInfoDomain user) {
		getSqlMapClientTemplate().update("userinfo.update", user);
	}

	@Override
	public void delete(Long id) {
		getSqlMapClientTemplate().delete("userinfo.delete", id);
	}

	@Override
	public UserInfoDomain findUserByNameAndPasswd(String username,
			String password) {
		Map<String, String> paramap = new HashMap<String, String>();
		paramap.put("username", username);
		paramap.put("password", password);
		return (UserInfoDomain) getSqlMapClientTemplate().queryForObject(
				"userinfo.find_user_by_name_and_passwd", paramap);
	}

}
