package com.tuanshop.bb.dao.impl;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.RoleInfoDao;
import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.pojo.RoleInfoDomain;
import com.tuanshop.bb.pojo.UserInfoDomain;
@Repository
public class RoleInfoDaoImpl extends BaseDao implements RoleInfoDao{

	@Override
	public void add(RoleInfoDomain roleinfo) {
	
		super.getSqlMapClientTemplate().insert("Role.addRole",roleinfo);
	}

	@Override
	public void delete(Long id) {
		
		super.getSqlMapClientTemplate().delete("Role.delRole",id);
	}

	@Override
	public void update(RoleInfoDomain roleinfo) {
	
		super.getSqlMapClientTemplate().update("Role.update",roleinfo);
	}

	@Override
	public RoleInfoDomain findById(Long id) {
	
		return (RoleInfoDomain)super.getSqlMapClientTemplate().queryForObject("Role.findById",id);
	}

	@Override
	public RoleInfoDomain findByName(String name) {
		
		return (RoleInfoDomain)super.getSqlMapClientTemplate().queryForObject("Role.findByName",name);
	}

	@Override
	public RoleQuery<RoleInfoDomain> findRolePageList(
			RoleQuery<RoleInfoDomain> query) {
		return (RoleQuery<RoleInfoDomain>)listByQuery("Role.list_by_query", query);
		
	}

}
