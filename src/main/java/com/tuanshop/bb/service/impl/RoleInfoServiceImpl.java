package com.tuanshop.bb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.RoleInfoDao;
import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.pojo.RoleInfoDomain;
import com.tuanshop.bb.service.RoleInfoService;
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
@Autowired
	     private RoleInfoDao roleinfodao;
	
	@Override
	public void add(RoleInfoDomain releinfo) {
		
		roleinfodao.add(releinfo);
	}

	@Override
	public void delete(Long id) {
		roleinfodao.delete(id);
		
	}

	@Override
	public void update(RoleInfoDomain roleinfo) {
		roleinfodao.update(roleinfo);
		
	}

	@Override
	public RoleInfoDomain findById(Long id) {
		// TODO Auto-generated method stub
		return roleinfodao.findById(id);
	}

	@Override
	public RoleInfoDomain findByName(String name) {
		// TODO Auto-generated method stub
		return roleinfodao.findByName(name);
	}

	@Override
	public RoleQuery<RoleInfoDomain> queryRoleInfoPageList(
			RoleQuery<RoleInfoDomain> query) {
		// TODO Auto-generated method stub
		return roleinfodao.findRolePageList(query);
	}

}
