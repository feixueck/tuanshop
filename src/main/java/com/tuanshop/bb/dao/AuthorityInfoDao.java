package com.tuanshop.bb.dao;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.query.AuthorityQuery;
import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.pojo.AuthorityInfoDomain;


@Repository
public interface AuthorityInfoDao {
	
	/**
	 * 
	 * @param releinfo
	 */
	void add(AuthorityInfoDomain authorityinfo);
	/**
	 * 
	 * @param releinfo
	 */
	void delete(Long id );
	/**
	 * 
	 * @param releinfo
	 */
	void update(AuthorityInfoDomain authorityinfo);
	/**
	 * 
	 * @param releinfo
	 */
	AuthorityInfoDomain findById(Long id);
	/**
	 * 
	 * @param releinfo
	 */
	AuthorityInfoDomain findByName(String name);
	/**
	 * 
	 * @param query
	 * @return
	 */
	AuthorityQuery<AuthorityInfoDomain> findAuthorityPageList(AuthorityQuery<AuthorityInfoDomain> query);


}
