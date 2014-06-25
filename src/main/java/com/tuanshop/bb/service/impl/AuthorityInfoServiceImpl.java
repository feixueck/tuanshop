package com.tuanshop.bb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.AuthorityInfoDao;
import com.tuanshop.bb.dao.query.AuthorityQuery;
import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.pojo.AuthorityInfoDomain;
import com.tuanshop.bb.service.AuthorityInfoService;

@Service
public class AuthorityInfoServiceImpl implements AuthorityInfoService{
	@Autowired
	private AuthorityInfoDao autyority;
	@Override
	public void add(AuthorityInfoDomain authorityinfo) {
		// TODO Auto-generated method stub
		autyority.add(authorityinfo);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		autyority.delete(id);
	}

	@Override
	public void update(AuthorityInfoDomain authorityinfo) {
		// TODO Auto-generated method stub
		autyority.update(authorityinfo);
	}

	@Override
	public AuthorityInfoDomain findById(Long id) {
		// TODO Auto-generated method stub
		return autyority.findById(id);
	}

	@Override
	public AuthorityInfoDomain findByName(String name) {
		// TODO Auto-generated method stub
		return autyority.findByName(name);
	}

	@Override
	public AuthorityQuery<AuthorityInfoDomain> findAuthorityPageList(
			AuthorityQuery<AuthorityInfoDomain> query) {
		// TODO Auto-generated method stub
		return autyority.findAuthorityPageList(query);
	}

}
