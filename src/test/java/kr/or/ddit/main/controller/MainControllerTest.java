package kr.or.ddit.main.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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
		assertNotNull(mav.getModel().get("rangers"));
		assertNotNull(mav.getModel().get("userVo"));
	}
	
	
	
	@Test
	public void mainViewAndExpectTest() throws Exception {

		mockMvc.perform(get("/main")).andExpect(status().isOk())
									 .andExpect(view().name("main"))
									 .andExpect(model().attribute("mainUserId", "brown"))
									 .andExpect(model().attributeExists("rangers"))
									 .andExpect(model().attributeExists("userVo"));
		
	}
	
	/**
	* Method : mainViewMavTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : ModelAndView 객체를 이용한 main페이지 요청 테스트
	 * @throws Exception 
	*/
	@Test
	public void mainViewMavTest() throws Exception {
		/***Given***/
		

		/***When***/
		MvcResult mvcResult= mockMvc.perform(get("/mainMav")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		

		/***Then***/
		//viewName에 기대하는 문자열로 리턴되는지
		assertEquals("main", mav.getViewName());
		
		
		logger.debug("mav.getModel : {}", mav.getModel());
		//model객체에 controller에서 설정한 속성이 있는지
		assertEquals("brown", mav.getModel().get("mainUserId"));
		assertNotNull(mav.getModel().get("rangers"));
	}
	
	
	/**
	* Method : pathVariableTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : @PathVariable 테스트
	 * @throws Exception 
	*/
	@Test
	public void pathVariableTest() throws Exception {
		/***Given***/
		

		/***When***/
		mockMvc.perform(get("/main/pathvariable/brown")).andExpect(status().isOk())
		 												.andExpect(view().name("main"));
		/***Then***/
	}
	
	
	/**
	* Method : pathVariableTest2
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : @PathVariable 테스트
	 * @throws Exception 
	*/
	@Test
	public void pathVariableTest2() throws Exception {
		/***Given***/
		

		/***When***/
		mockMvc.perform(get("/main/pathvariable/sally")).andExpect(status().isOk())
		 												.andExpect(view().name("main"));
		/***Then***/
	}
	
	/**
	* Method : requestHeaderTest
	* 작성자 : PC24
	* 변경이력 :
	* @throws Exception
	* Method 설명 : @RequestHeader test
	*/
	@Test
	public void requestHeaderTest() throws Exception {
		/***Given***/
		
		
		/***When***/
		mockMvc.perform(get("/main/header").accept("text/html")).andExpect(status().isOk())
											.andExpect(view().name("main"));
		/***Then***/
	}


}
