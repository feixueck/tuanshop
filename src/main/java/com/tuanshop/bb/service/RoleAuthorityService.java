package com.tuanshop.bb.service;

import java.util.List;

import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;

public interface RoleAuthorityService {

	void add(RoleAuthorityInfoDomain raInfo);

	void deleteByRole(Long roleId);

	List<RoleAuthorityInfoDomain> getList(RoleAuthorityInfoDomain raInfo);
}
