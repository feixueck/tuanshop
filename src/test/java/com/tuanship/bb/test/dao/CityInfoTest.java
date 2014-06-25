package com.tuanship.bb.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tuanshop.bb.dao.CityInfoDao;
import com.tuanshop.bb.pojo.dianping.CityDomain;


@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class CityInfoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private CityInfoDao cityinfodao;
    @Test
    public void add(){
    	CityDomain cd=new CityDomain();
    	for(int i=0;i<20 ;i++){
    		cd.setDescription("北京"+i+"号");
    		cd.setName("北京");
    		cityinfodao.add(cd);
    	}
    }
}
