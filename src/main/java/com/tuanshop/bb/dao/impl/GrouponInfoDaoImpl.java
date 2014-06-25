package com.tuanshop.bb.dao.impl;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.GroupInfoDao;
import com.tuanshop.bb.dao.GrouponInfoDao;
import com.tuanshop.bb.pojo.dianping.GroupInfoDomain;
import com.tuanshop.bb.pojo.dianping.GrouponInfoDomain;
@Repository
public class GrouponInfoDaoImpl extends BaseDao implements GrouponInfoDao {

	@Override
	public void add(GrouponInfoDomain grouponinfo) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Groupon.addGroupon",grouponinfo);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GrouponInfoDomain grouponinfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GrouponInfoDomain findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrouponInfoDomain findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
