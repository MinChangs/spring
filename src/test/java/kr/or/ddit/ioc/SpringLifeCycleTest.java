package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import kr.or.ddit.ioc.placeholder.DbInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-placeholder.xml")
public class SpringLifeCycleTest {
	
	@Resource(name = "dbInfo")
	private DbInfo dbinfo; 

	/**
	* Method : placeholderTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : springPlaceholderTest
	*/
	@Test
	public void LifeCycleTest() {
		
		/***Given***/
		

		/***When***/

		/***Then***/
		assertEquals("oracle.jdbc.driver.OracleDriver", dbinfo.getDriver());
		assertEquals("jdbc:oracle:thin:@192.168.0.99:1521:xe", dbinfo.getUrl());
		assertEquals("pc24", dbinfo.getUsername());
		assertEquals("java", dbinfo.getPassword());
		
		
	}

}
