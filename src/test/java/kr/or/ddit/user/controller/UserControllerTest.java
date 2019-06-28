package kr.or.ddit.user.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.UserVo;

public class UserControllerTest extends ControllerTestEnv {
	
	/**
	* Method : userListTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 테스트
	 * @throws Exception 
	*/
	@Test
	public void userListTest() throws Exception {
		
		/***Given***/

		/***When***/
		MvcResult mvcResult= mockMvc.perform(get("/user/list")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals("user/userList", mav.getViewName());
		assertEquals(109, ((List<UserVo>)mav.getModelMap().get("userList")).size());
		
	}
	
	
	/**
	* Method : userPagingListTest
	* 작성자 : PC24
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 페이징 리스트 테스트
	*/
	@Test
	public void userPagingListTest() throws Exception {
		
		/***Given***/
		
		/***When***/
		MvcResult mvcResult= mockMvc.perform(get("/user/pagingList")
											 .param("page", "2")
											 .param("pageSize","10"))
											 .andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		List<UserVo> userList= (List<UserVo>) mav.getModelMap().get("userList");
		int paginationSize = (Integer)mav.getModelMap().get("paginationSize");
		PageVo pageVo = (PageVo)mav.getModelMap().get("pageVo");
		
		
		/***Then***/
		assertEquals("tiles.userPagingList", viewName);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);
		assertEquals(2, pageVo.getPage());
		assertEquals(10, pageVo.getPageSize());
		
	}
	
	
	/**
	* Method : userPagingListWithoutParameterTest
	* 작성자 : PC24
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 페이징리스트 테스트(page, pageSize 파라미터 없이 호출)
	*/
	@Test
	public void userPagingListWithoutParameterTest() throws Exception {
		
		/***Given***/
		
		/***When***/
		MvcResult mvcResult= mockMvc.perform(get("/user/pagingList")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		List<UserVo> userList= (List<UserVo>) mav.getModelMap().get("userList");
		int paginationSize = (Integer)mav.getModelMap().get("paginationSize");
		PageVo pageVo = (PageVo)mav.getModelMap().get("pageVo");
		
		
		/***Then***/
		assertEquals("tiles.userPagingList", viewName);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);
		
		//pageVo의 equals와 hash코드를 구현해서 각 객체의 값들만 비교
		assertEquals(new PageVo(1,10) , pageVo);
		
		assertEquals(1, pageVo.getPage());
		assertEquals(10, pageVo.getPageSize());
		
	}
	
	/**
	* Method : userTest
	* 작성자 : PC24
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 상세조회 테스트 
	*/
	@Test
	public void userTest() throws Exception {
		/***Given***/
		

		/***When***/
		MvcResult mvcResult= mockMvc.perform(get("/user/user").param("userId", "brown")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		UserVo userVo = (UserVo)mav.getModelMap().get("userInfo");
		/***Then***/
		assertNotNull(userVo);
		assertEquals("user/user", viewName);
		assertEquals("브라운", userVo.getName());
	}
	/**
	* Method : userFormGetTest
	* 작성자 : PC24
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 입력화면 요청
	*/
	@Test
	public void userFormGetTest() throws Exception {
		
		
		/***When***/
		mockMvc.perform(get("/user/form")).andExpect(view().name("user/userForm"));
	}
	
	
	/**
	* Method : userFormPostSuccessTest
	* 작성자 : PC24
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 등록테스트
	*/
	@Test
	public void userFormPostSuccessTest() throws Exception {
		
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MockMultipartFile file = new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f));
		/***When***/
		mockMvc.perform(fileUpload("/user/form")
				.file(file)
				.param("userId", "userTest12301")
				.param("name", "대덕인")
				.param("alias", "asdasd")
				.param("birth", "2019-08-08")
				.param("pass", "userTest2011234")
				.param("addr1", "대전")
				.param("zipcd", "12346")
				.param("pass", "123465asdasd"))
				.andExpect(view().name("redirect:/user/pagingList"));

		/***Then***/
		
	}
	
	
	/**
	* Method : userFormPostFailTest
	* 작성자 : PC24
	* 변경이력 :
	* @throws Exception
	* Method 설명 :사용자 등록테스트(FAIL시나리오)
	*/
	@Test
	public void userFormPostFailTest() throws Exception {
		
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MockMultipartFile file = new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f));
		/***When***/
		mockMvc.perform(fileUpload("/user/form")
				.file(file)
				.param("userId", "brown")
				.param("name", "대덕인")
				.param("alias", "asdasd")
				.param("birth", "2019-08-08")
				.param("pass", "userTest2011234")
				.param("addr1", "대전"))
				.andExpect(view().name("user/userForm"));

		/***Then***/
		
	}
	
	/**
	* Method : profileTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 사진 응답 테스트
	 * @throws Exception 
	*/
	@Test
	public void profileTest() throws Exception {
		mockMvc.perform(get("/profile").param("userId", "brown")).andExpect(status().isOk());
	}
	
	
	/**
	* Method : userModifyGetTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 수정화면 요청 테스트
	 * @throws Exception 
	*/
	@Test
	public void userModifyGetTest() throws Exception {
		/***Given***/
		

		/***When***/
		
		MvcResult mvcResult= mockMvc.perform(get("/user/modify").param("userId", "brown")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
		UserVo userVo = (UserVo)mav.getModelMap().get("userInfo");
		/***Then***/
		assertEquals("user/userModify", viewName);
		assertEquals("브라운", userVo.getName());
	}
	
	@Test
	public void userModifyPostTest() throws Exception {
		
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/sally.png");
		MockMultipartFile file = new MockMultipartFile("profile", f.getName(), "", new FileInputStream(f));
		/***When***/
		mockMvc.perform(fileUpload("/user/form")
				.file(file)
				.param("userId", "userTest201")
				.param("name", "대덕인")
				.param("alias", "asdasd")
				.param("birth", "2019-08-08")
				.param("addr1", "대전")
				.param("zipcd", "12346")
				.param("pass", "123465asdasd"))
				.andExpect(view().name("redirect:/user/pagingList"));

		/***Then***/
		
	}
	
	
	   
	



}
