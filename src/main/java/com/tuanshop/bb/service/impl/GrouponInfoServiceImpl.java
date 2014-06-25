package com.tuanshop.bb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.GrouponInfoDao;
import com.tuanshop.bb.pojo.dianping.GrouponInfoDomain;
import com.tuanshop.bb.service.GrouponInfoService;
@Service
public class GrouponInfoServiceImpl implements GrouponInfoService{
       @Autowired
       private GrouponInfoDao grouponinfodao;
	@Override
	public void add(GrouponInfoDomain grouponInfoDomain) {
		// TODO Auto-generated method stub
		grouponinfodao.add(grouponInfoDomain);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GrouponInfoDomain grouponInfoDomain) {
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
