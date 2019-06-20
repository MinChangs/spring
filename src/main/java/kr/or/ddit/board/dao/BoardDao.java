package kr.or.ddit.board.dao;

import org.springframework.stereotype.Repository;
//spring bean이름 : 인스턴스 생성규칭 -> 클래스명에서 첫글자를 소문자로 -> boardDao
//Spring bean 이름을 임의로 주고 싶은경우@Repository("bDao")
@Repository
public class BoardDao implements IBoardDao {

	@Override
	public String sayHello() {
		return "boardDao sayHello";
	}

}
