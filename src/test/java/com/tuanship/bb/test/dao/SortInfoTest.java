package com.tuanship.bb.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


import com.tuanshop.bb.dao.SortInfoDao;

import com.tuanshop.bb.pojo.dianping.SortDomain;


@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class SortInfoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private SortInfoDao sortinfodao;
    @Test
    public void add(){
    	SortDomain sd=new SortDomain();
    	for(int i=0;i<20 ;i++){
    		sd.setMainName("娱乐");
    		sd.setMaxName("玩");
    		sd.setDescription("asd");
    		sortinfodao.add(sd);
    	}
    }
}
