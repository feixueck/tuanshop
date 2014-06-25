package com.tuanshop.bb.dao;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.pojo.UserInfoDomain;

@Repository
public interface UserInfoDao {
	Long addUser(UserInfoDomain user);

	UserInfoDomain findId(Long id);

	UserQuery<UserInfoDomain> findUserPageList(UserQuery<UserInfoDomain> query);

	void update(UserInfoDomain user);
	
    void	delete(Long id);

	UserInfoDomain findUserByNameAndPasswd(String username, String password);
    
    
}
