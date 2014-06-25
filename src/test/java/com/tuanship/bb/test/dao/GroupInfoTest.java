package com.tuanship.bb.test.dao;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tuanshop.bb.dao.GroupInfoDao;

import com.tuanshop.bb.pojo.dianping.GroupInfoDomain;


@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class GroupInfoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private GroupInfoDao groupInfoDao;
@Test
    public void add(){
    	GroupInfoDomain sd=new GroupInfoDomain();
    	for(int i=0;i<20 ;i++){
         sd.setTuanId("1-111111"+i);
         groupInfoDao.add(sd);
    	}
    }
}
