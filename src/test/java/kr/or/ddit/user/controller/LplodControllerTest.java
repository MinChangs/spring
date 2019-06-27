package kr.or.ddit.user.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.UserVo;

public class LplodControllerTest extends ControllerTestEnv{

	@Test
	public void lprodPagingListTest() throws Exception {
		MvcResult mvcResult= mockMvc.perform(get("/lprod/pagingList")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		List<UserVo> userList= (List<UserVo>) mav.getModelMap().get("lprodList");
		int paginationSize = (Integer)mav.getModelMap().get("LpaginationSize");
		PageVo pageVo = (PageVo)mav.getModelMap().get("pageVo");
		
		
		/***Then***/
		assertEquals("lprod/lprodList", viewName);
//		assertEquals(10, userList.size());
//		assertEquals(11, paginationSize);
//		
//		//pageVo의 equals와 hash코드를 구현해서 각 객체의 값들만 비교
//		assertEquals(new PageVo(1,10) , pageVo);
//		
//		assertEquals(1, pageVo.getPage());
//		assertEquals(10, pageVo.getPageSize());
	}

}
