package com.tuanship.bb.test.dao;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.tuanshop.bb.dao.GrouponInfoDao;
import com.tuanshop.bb.pojo.dianping.GrouponInfoDomain;


@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class GrouponInfoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private GrouponInfoDao grouponInfoDao;
@Test
    public void add(){
    	GrouponInfoDomain sd=new GrouponInfoDomain();
    	for(int i=0;i<20 ;i++){
       sd.setCityName("第"+i+"条");
       sd.setSource("第"+i+"条");
       sd.setTitle("第"+i+"条");
       sd.setDescribe("第"+i+"条");
       sd.setImgUrl("第"+i+"条");
       sd.setMaxType("第"+i+"条");
       sd.setMainTipe("第"+i+"条");
      // sd.setStartTime(startTime);
     //  sd.setOverTime(overTime);
       sd.setPurchaseCount("第"+i+"条");
       sd.setPrice("第"+i+"条");
       sd.setCurrentPrice("第"+i+"条");
       sd.setCriteria("第"+i+"条");
       sd.setNotice("第"+i+"条");
       sd.setDetail("第"+i+"条");
       sd.setBsName("第"+i+"条");
       sd.setPhon("第"+i+"条");
       sd.setBsAddress("第"+i+"条");
       sd.setLongitude("第"+i+"条");
       sd.setLatitude("第"+i+"条");
       sd.setTrafficInfo("第"+i+"条");
       
         grouponInfoDao.add(sd);
    	}
    }
}
