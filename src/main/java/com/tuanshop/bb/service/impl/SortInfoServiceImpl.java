package com.tuanshop.bb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.SortInfoDao;
import com.tuanshop.bb.pojo.dianping.SortDomain;
import com.tuanshop.bb.service.SortInfoService;
@Service
public class SortInfoServiceImpl implements SortInfoService {
	@Autowired
    private SortInfoDao sortinfodao;
	@Override
	public void add(SortDomain sortdomain) {
		// TODO Auto-generated method stub
		sortinfodao.add(sortdomain);
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
