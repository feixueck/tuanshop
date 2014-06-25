package com.tuanshop.bb.biz.tuanshop.schedule;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.XMLUnit;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tuanshop.bb.biz.tuanshop.dto.LaShouCityDTO;
import com.tuanshop.bb.biz.tuanshop.dto.LaShouTuans;
import com.tuanshop.bb.biz.tuanshop.dto.vo.BaseUrl;
import com.tuanshop.bb.biz.tuanshop.dto.vo.DataVo;
import com.tuanshop.bb.biz.tuanshop.dto.vo.DisplayVo;
import com.tuanshop.bb.biz.tuanshop.dto.vo.ShopVo;
import com.tuanshop.bb.util.XmlUtil;

public class XstreamTest {

	public static void main(String[] args) throws IOException {
		/*
		 * Person p = new Person(); p.setAge("12"); p.setName("tom");
		 * p.setUser("zuoshuai");
		 * 
		 * XStream xstream = new XStream();
		 * xstream.processAnnotations(p.getClass());
		 * System.out.println(xstream.toXML(p));
		 * 
		 * String xml=
		 * "<person><user>zuoshuai</user><name>tom</name><age>12</age>s</person>"
		 * ; Person person=XmlUtil.xmltoBean(xml, Person.class);
		 * System.out.println(person.getUser());
		 */

		// InputStream in = XstreamTest.class.getResourceAsStream("/tmp.xml");
		// String xml = IOUtils.toString(in);
		// LaShouCityDTO citydto = XmlUtil.xmltoBean(xml, LaShouCityDTO.class);
		// System.out.println(citydto.getUrlList().get(0));

		InputStream in = XstreamTest.class.getResourceAsStream("/tuan.xml");
		String xml = IOUtils.toString(in);
		LaShouTuans citydto = XmlUtil.xmltoBean(xml, LaShouTuans.class);
		System.out.println(citydto.getTuans().get(0));

		// DisplayVo display = new DisplayVo();
		// display.setWebsite("baidu");
		// display.setCategory("meixshi");
		// ShopVo svo = new ShopVo();
		// svo.setAddr("addr");
		// svo.setArea("usa");
		// ShopVo svo1 = new ShopVo();
		// svo1.setAddr("addr");
		// svo1.setArea("usa");
		// List<ShopVo> shoplist = new ArrayList<ShopVo>();
		// shoplist.add(svo);
		// shoplist.add(svo1);
		//
		// DataVo data = new DataVo();
		// data.setDisplay(display);
		// data.setShopList(shoplist);
		// System.out.println(XmlUtil.toXml(data));

		// CityDTO dto=new CityDTO();
		// List<BaseUrl> urllist=new ArrayList<BaseUrl>();
		// BaseUrl url=new BaseUrl();
		// url.setCityId("city1");
		// url.setCityName("name1");
		// url.setCityUrl("url1");
		//
		// BaseUrl url2=new BaseUrl();
		// url2.setCityId("city2");
		// url2.setCityName("name2");
		// url2.setCityUrl("url2");
		// urllist.add(url2);
		// urllist.add(url);
		// dto.setUrlList(urllist);
		// System.out.println(XmlUtil.toXml(dto));

	}
	/**
	 * 
	 * @author Administrator
	 * 
	 */

}

@XStreamAlias("person")
class Person {
	@XStreamAlias("user")
	private String user;
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("age")
	private String age;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
