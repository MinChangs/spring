package kr.or.ddit.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.UserVo;

@Service
public class UserService implements IUserService {
	@Resource(name="userDao")
	private IUserDao userdao;
	
	@Override
	public List<UserVo> useList() {
		return userdao.useList();
	}

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

	@Override
	public int deleteUser(String userId) {
		return userdao.deleteUser(userId);
	}

	@Override
	public UserVo getUser(String userId) {
		return userdao.getUser(userId);
	}

}
