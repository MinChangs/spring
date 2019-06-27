package kr.or.ddit.user.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IUserDao {
	
	/**
	* Method : useList
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	*/
	List<UserVo> useList();
	
	
	/**
	* Method : insertUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	int insertUser(UserVo userVo);


	/**
	* Method : deleteUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 삭제
	*/
	int deleteUser(String userId);
	
	/**
	* Method : getUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	UserVo getUser(String userId);
	
	
	/**
	* Method : updateUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 업데이트
	*/
	int updateUser(UserVo userVo);
	
	
	
	/**
	* Method : userPagingList
	* 작성자 : PC24
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	List<UserVo> userPagingList(PageVo pageVo);
	
	
	/**
	* Method : userCnt
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	*/
	int usersCnt();
	
	
	
	/**
	* Method : userListForPassEncrypt
	* 작성자 : PC24
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 암호화 적용대상 사용자 전체조회
	*/
	List<UserVo> userListForPassEncrypt(SqlSessionTemplate sqlSession);


	/**
	* Method : updateUserEncryptPass
	* 작성자 : PC24
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 사용자 비밀번호 암호화적용
	*/
	int updateUserEncryptPass(SqlSessionTemplate sqlSession, UserVo userVo);
	
	
}

