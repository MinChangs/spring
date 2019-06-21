package kr.or.ddit.user.dao;

import java.util.List;

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
	
	
	int insertUser(UserVo userVo);


	int deleteUser(String userId);
}
