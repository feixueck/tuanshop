package com.tuanshop.bb.service;



import com.tuanshop.bb.dao.query.AuthorityQuery;

import com.tuanshop.bb.pojo.AuthorityInfoDomain;

public interface AuthorityInfoService {

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



