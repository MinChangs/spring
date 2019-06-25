package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

@Repository
public class UserDao implements IUserDao {
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;

	/**
	* Method : useList
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<UserVo> useList() {
		return sqlSession.selectList("user.userList");
	}

	/**
	* Method : insertUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		return sqlSession.insert("user.insertUser",userVo);
	}
	
	/**
	* Method : deleteUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 삭제
	*/

	@Override
	public int deleteUser(String userId) {
		return sqlSession.delete("user.deleteUser",userId);
	}

	
	/**
	* Method : getUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	@Override
	public UserVo getUser(String userId) {
		return sqlSession.selectOne("user.getUser",userId);
	}

	/**
	* Method : updateUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 업데이트
	*/
	@Override
	public int updateUser(UserVo userVo) {
		return sqlSession.update("user.updateUser",userVo);
	}

	
	
	/**
	* Method : userPagingList
	* 작성자 : PC24
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Override
	public List<UserVo> userPagingList(PageVo pageVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("user.userPagingList", pageVo);
	}

	/**
	* Method : usersCnt
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	*/
	@Override
	public int usersCnt() {
		return sqlSession.selectOne("user.usersCnt");
	}

	/**
	* Method : userListForPassEncrypt
	* 작성자 : PC24
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 암호화 적용대상 사용자 전체조회
	*/
	@Override
	public List<UserVo> userListForPassEncrypt(SqlSessionTemplate sqlSession) {

		return sqlSession.selectList("user.userListForPassEncrypt");
	}

	/**
	* Method : updateUserEncryptPass
	* 작성자 : PC24
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 사용자 비밀번호 암호화적용
	*/
	@Override
	public int updateUserEncryptPass(SqlSessionTemplate sqlSession, UserVo userVo) {
		// TODO Auto-generated method stub
		return sqlSession.update("user.updateUserEncryptPass",userVo);
	}

	

	
	
}
