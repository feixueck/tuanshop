package com.tuanshop.bb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.RoleAuthorityDao;
import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;
@Repository
public class RoleAuthorityDaoImpl extends BaseDao implements RoleAuthorityDao {

	@Override
	public void add(RoleAuthorityInfoDomain rAuthdomain) {
		super.getSqlMapClientTemplate().insert("roleAuthority.add", rAuthdomain);
	}

	@Override
	public void deleteByRole(Long roleId) {
		super.getSqlMapClientTemplate().delete("roleAuthority.delete", roleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleAuthorityInfoDomain> getRoleAuthorityList(RoleAuthorityInfoDomain rAuthdomain) {
		return getSqlMapClientTemplate().queryForList("roleAuthority.get_role_auth_list", rAuthdomain);
	}

}
