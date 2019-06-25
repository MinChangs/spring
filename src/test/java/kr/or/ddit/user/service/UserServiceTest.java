package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest extends LogicTestEnv {
	@Resource(name="userService")
	private IUserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	

	/**
	* Method : userListTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회 테스트
	*/
	@Test
	public void userListTest() {
		
		/***Given***/
		

		/***When***/
		List<UserVo> userList = userService.userList();
		/***Then***/
		assertNotNull(userList);
		assertTrue(userList.size()>100);
	}
	
	
	/**
	* Method : insertUserTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	*/
	@Test
	public void insertUserTest(){
		/***Given***/
		//사용자 정보를 담고 있는 vo 객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;
		try {
			 userVo = new UserVo("대덕인", "smcsmc1","중앙로","userTest12345","대전광역시 중구 중알로76","영민빌딩 2층 204호","34940",sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/***When***/
		//userDao.insertUser();
		int inserCnt = userService.insertUser(userVo);
		

		/***Then***/
		//insertCnt();
		assertEquals(1, inserCnt);
		
		//data삭제 
		userService.deleteUser(userVo.getUserId());
		
	}
	
	
	/**
	* Method : getUserTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 정보 테스트
	*/
	@Test
	public void getUserTest() {
		/***Given***/
		String userId="brown";

		/***When***/
		UserVo userVo = userService.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getName());
		assertEquals("곰", userVo.getAlias());
		
	}
	
	
	/**
	* Method : userPagingListTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 페이징 리스트 테스트
	*/
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");

		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);
		assertEquals("adm", userList.get(0).getUserId());
	}
	
	
	
	
	


}
