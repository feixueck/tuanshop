package com.tuanshop.bb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.RoleAuthorityDao;
import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;
import com.tuanshop.bb.service.RoleAuthorityService;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {
	@Autowired
	private RoleAuthorityDao roleAuthorityDao;

	@Override
	public void add(RoleAuthorityInfoDomain raInfo) {
		roleAuthorityDao.add(raInfo);
	}

	@Override
	public void deleteByRole(Long roleId) {
		roleAuthorityDao.deleteByRole(roleId);
	}

	@Override
	public List<RoleAuthorityInfoDomain> getList(RoleAuthorityInfoDomain raInfo) {
		return roleAuthorityDao.getRoleAuthorityList(raInfo);
	}

}
