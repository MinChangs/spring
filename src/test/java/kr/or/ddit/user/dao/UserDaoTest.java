package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends LogicTestEnv{

	@Resource(name="userDao")
	private IUserDao userDao;
	

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
		List<UserVo> userList = userDao.userList();
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
		int inserCnt = userDao.insertUser(userVo);
		

		/***Then***/
		//insertCnt();
		assertEquals(1, inserCnt);
		
		//data삭제 
		userDao.deleteUser(userVo.getUserId());
		
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
		UserVo userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getName());
		assertEquals("곰", userVo.getAlias());
		
	}
	
	@Test
	public void updateUserTest(){
		/***Given***/
		//사용자 정보를 담고 있는 vo 객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;
		try {
			 userVo = new UserVo("대덕인", "userTest","중앙로","userTest1234","대전광역시 중구 중알로76","영민빌딩 2층 204호","34940",sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/***When***/
		//userDao.insertUser();
		int updateCnt = userDao.updateUser(userVo);
		

		/***Then***/
		//insertCnt();
		assertEquals(1, updateCnt);
		
		
	}
	
	
	/**
 	 * Method : userPagingListTest
	 * 작성자 : PC24
	 * 변경이력 :
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		
		List<UserVo> userList = userDao.userPagingList(pageVo);

		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
	}
	

	/**
	* Method : userCntTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	*/
	@Test
	public void usersCntTest() {
		/***Given***/
		

		/***When***/
		int usersCnt = userDao.usersCnt();
		
		
		/***Then***/
		assertEquals(109, usersCnt);

	}

}
