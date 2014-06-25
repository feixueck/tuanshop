package com.tuanshop.bb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;
@Repository
public interface RoleAuthorityDao {

	void add(RoleAuthorityInfoDomain rAuthdomain);

	void deleteByRole(Long roleId);

	List<RoleAuthorityInfoDomain> getRoleAuthorityList(RoleAuthorityInfoDomain rAuthdomain);

}
