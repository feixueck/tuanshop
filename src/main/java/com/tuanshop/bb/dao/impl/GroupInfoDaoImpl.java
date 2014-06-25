package com.tuanshop.bb.dao.impl;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.GroupInfoDao;
import com.tuanshop.bb.pojo.dianping.GroupInfoDomain;
@Repository
public class GroupInfoDaoImpl extends BaseDao implements GroupInfoDao{

	@Override
	public void add(GroupInfoDomain groupinfo) {
		// TODO Auto-generated method stub
		                    getSqlMapClientTemplate().insert("Group.addGroup",groupinfo);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GroupInfoDomain groupinfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GroupInfoDomain findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupInfoDomain findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
