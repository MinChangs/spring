package kr.or.ddit.main.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;


//일반 자바환경 -> 웹환경
//기존JUnit은 자바코드 로직만 테스트할 수 있었는데 웹 환경으로 테스트하기위해 어노테이션을 붙인다.
//applicationContext --> 웹 환경의 applicationContext 생성
public class MainControllerTest extends ControllerTestEnv {
	private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class);
	
	
	/**
	* Method : mainViewTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : Main View 호출 테스트
	 * @throws Exception 
	*/
	@Test
	public void mainViewTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult= mockMvc.perform(get("/main")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName= mav.getViewName();
		String userId= (String)mav.getModel().get("mainUserId");
		
		/***Then***/
		assertEquals("main", viewName);
		assertEquals("brown", userId);
	}
	
	
	
	@Test
	public void mainViewAndExpectTest() throws Exception {

		mockMvc.perform(get("/main")).andExpect(status().isOk())
									 .andExpect(view().name("main"))
									 .andExpect(model().attribute("mainUserId", "brown"));
		
	}

}
