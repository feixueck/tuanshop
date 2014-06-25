package com.tuanshop.bb.dao.impl;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.SortInfoDao;
import com.tuanshop.bb.pojo.dianping.SortDomain;
@Repository
public class SortInfoDaoImpl extends BaseDao implements SortInfoDao {

	@Override
	public void add(SortDomain sortdomain) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Sort.addSort",sortdomain);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SortDomain sortdomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SortDomain findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortDomain findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
