package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.UserVo;

@Transactional
@Service
public class UserService implements IUserService {
	@Resource(name="userDao")
	private IUserDao userdao;
	
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	
	/**
	* Method : useList
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	*/
	@Override
	public List<UserVo> userList() {
		return userdao.userList();
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
		return userdao.insertUser(userVo);
		
		/*
		  int cnt =0;
		  //첫번째 입력 
		  cnt += userdao.insertUser(userVo); 
		  //같은 내용 재입력 
		  cnt + =userdao.insertUser(userVo);
		  
		  --> 트랜젝션이 끝나기전에 재입력이 일어났기때문에 롤백되서 첫번째 입력된 내용도 저장되지 않는다 return cnt;
		 */
		
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
		return userdao.deleteUser(userId);
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
		return userdao.getUser(userId);
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
	public Map<String, Object> userPagingList(PageVo pageVo) {
		// 1. List<UserVo>, usersCnt를 필드로하는 vo
		// 2. List<Object>, resultList = new ArrayList<Object>();
		// result.add(userList);
		// result.add(usersCnt);
		// 3. Map<String,Object> resultMap = new HashMap<String, Object>();
		// resultMap.put("userList",userList);
		// resultMap.put("usersCnt",usersCnt);
		// 보통 3번방법으로 한다

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userdao.userPagingList(pageVo));
//				resultMap.put("usersCnt", dao.usersCnt());
		
		//usersCnt --> paginationSize변경
		int usersCnt = userdao.usersCnt();
		//pageSize-- > pageVo.getPageSize();
		int paginationSize= (int) Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		return resultMap;
	}

	
	/**
	* Method : encryptPassAllUser
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	*/
	@Override
	public int encryptPassAllUser() {
		//사용X
		if(1==1){
			return 0;
		}
		//0.sql 실행에 필요한 sqlSession 객체를 생성
		

		//1.모든 사용자 정보를 조회(단 기존 암호화 적용 사용자 제외) --> user.xml 쿼리 생성
		List<UserVo> userList = userdao.userListForPassEncrypt(sqlSession);
		//2. 조회된 사용자의 비밀번호를 암호화 적용 후 사용자 업데이트
		int updateCntSum=0;
		for(UserVo userVo : userList){
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = userdao.updateUserEncryptPass(sqlSession,userVo);
			updateCntSum+=updateCnt;
			//비정상처리
			if(updateCnt!=1){
				break;
			}
		}

		//3. sqlSession 객체를 commit, close
		return updateCntSum;
	}


	@Override
	public int updateUser(UserVo userVo) {
		return userdao.updateUser(userVo);
	}

}
