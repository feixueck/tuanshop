package com.tuanshop.bb.dao.impl;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.AuthorityInfoDao;
import com.tuanshop.bb.dao.BaseDao;
import com.tuanshop.bb.dao.query.AuthorityQuery;
import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.pojo.AuthorityInfoDomain;
import com.tuanshop.bb.pojo.RoleInfoDomain;
@Repository
public class AuthorityInfoDaoImpl extends BaseDao implements AuthorityInfoDao {

	@Override
	public void add(AuthorityInfoDomain authorityinfo) {
		// TODO Auto-generated method stub
    super.getSqlMapClientTemplate().insert("Authority.addAuthority",authorityinfo);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		super.getSqlMapClientTemplate().delete("Authority.dltAuthority",id);
		
	}

	@Override
	public void update(AuthorityInfoDomain authorityinfo) {
		// TODO Auto-generated method stub
		super.getSqlMapClientTemplate().update("Authority.update",authorityinfo);
	}

	@Override
	public AuthorityInfoDomain findById(Long id) {
		// TODO Auto-generated method stub
	
		return (AuthorityInfoDomain)super.getSqlMapClientTemplate().queryForObject("Authority.findauthid",id);
	}

	@Override
	public AuthorityInfoDomain findByName(String name) {
		// TODO Auto-generated method stub
		return (AuthorityInfoDomain)super.getSqlMapClientTemplate().queryForObject("",name);
	}

	@Override
	public AuthorityQuery<AuthorityInfoDomain> findAuthorityPageList(
			AuthorityQuery<AuthorityInfoDomain> query) {
		return (AuthorityQuery<AuthorityInfoDomain>)listByQuery("Authority.list_by_query", query);
		
	}

}
