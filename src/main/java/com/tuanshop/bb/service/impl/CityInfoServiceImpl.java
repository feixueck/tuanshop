package com.tuanshop.bb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.CityInfoDao;
import com.tuanshop.bb.pojo.dianping.CityDomain;
import com.tuanshop.bb.service.CityInfoService;
@Service
public class CityInfoServiceImpl implements CityInfoService {
  	@Autowired
	  private CityInfoDao cityinfodao;
	@Override
	public void add(CityDomain citydomain) {
		// TODO Auto-generated method stub
		cityinfodao.add(citydomain);
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
