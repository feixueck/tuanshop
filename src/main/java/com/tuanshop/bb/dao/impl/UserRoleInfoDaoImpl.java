package com.tuanshop.bb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.UserRoleInfoDao;
import com.tuanshop.bb.dao.query.UserRoleQuery;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;
@Repository
public class UserRoleInfoDaoImpl extends BaseDao implements UserRoleInfoDao{

	@Override
	public UserRoleQuery<UserRoleInfoDomain> findUserRolePageList(
			UserRoleQuery<UserRoleInfoDomain> query) {
		// TODO Auto-generated method stub
      return (UserRoleQuery<UserRoleInfoDomain>) listByQuery("userroleinfo.list_by_query", query);
	}

	@Override
	public void add(UserRoleInfoDomain userroleinfodomain) {
		// TODO Auto-generated method stub
		super.getSqlMapClientTemplate().insert("userroleinfo.addUserRole",userroleinfodomain);
	}

	@Override
	public List<UserRoleInfoDomain> findUserRole(Long id) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("userroleinfo.findUserRole",id);
	}

	@Override
	public List<UserRoleInfoDomain> findUserRoleList() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("userroleinfo.findUserRoleList");
	}

	@Override
	public void dltUserRole(Long userId) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("userroleinfo.dltUserRole",userId);
	}



}
