package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest extends LogicTestEnv {
	@Resource(name="userService")
	private IUserService userService;
	

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
		List<UserVo> userList = userService.useList();
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
			 userVo = new UserVo("대덕인", "smcsmc","중앙로","userTest1234","대전광역시 중구 중알로76","영민빌딩 2층 204호","34940",sdf.parse("2019-05-31"));
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


}
