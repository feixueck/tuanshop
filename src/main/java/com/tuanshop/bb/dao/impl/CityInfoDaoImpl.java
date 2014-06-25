package com.tuanshop.bb.dao.impl;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.CityInfoDao;
import com.tuanshop.bb.pojo.dianping.CityDomain;
@Repository
public class CityInfoDaoImpl extends BaseDao implements CityInfoDao {

	@Override
	public void add(CityDomain citydomain) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("City.addCity",citydomain);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CityDomain citydomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CityDomain findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDomain findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
