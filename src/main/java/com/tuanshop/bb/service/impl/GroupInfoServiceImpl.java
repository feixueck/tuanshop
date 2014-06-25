package com.tuanshop.bb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.GroupInfoDao;
import com.tuanshop.bb.pojo.dianping.GroupInfoDomain;
import com.tuanshop.bb.service.GroupInfoService;
@Service
public class GroupInfoServiceImpl implements GroupInfoService {
  @Autowired
 private GroupInfoDao groupinfodao;
	@Override
	public void add(GroupInfoDomain groupinfo) {
		// TODO Auto-generated method stub
		groupinfodao.add(groupinfo);
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
