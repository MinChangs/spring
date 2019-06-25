package kr.or.ddit.testenv;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:kr/or/ddit/config/spring/application-context.xml",
					   "classpath:kr/or/ddit/config/spring/root-context.xml",
					   "classpath:kr/or/ddit/config/spring/application-datasource-dev.xml",
	   				   "classpath:kr/or/ddit/config/spring/application-transaction.xml"})

@WebAppConfiguration
public class ControllerTestEnv {
	@Autowired
	protected WebApplicationContext ctx; //webApplicationContext --> spring Container역할을 한다.
	protected MockMvc mockMvc;//mokMvc -->dispatcher Servlet역할을 한다 
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Ignore
	@Test
	public void init() {
		
	}

}
