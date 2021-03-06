package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

@Configuration
public class ApplicationIocConfig {
	
	//<bean id="boardDao" class="kr.or.ddit.board.dao.BoardDao
	@Bean
	public IBoardDao boardDao() {
		return new BoardDao();
	}
	
	/*
	 * <bean id="boardService" class="kr.or.ddit.board.service.BoardService"> <!--
	 * 
	 * <property name="boardDao" ref="boardDao"></property>
	 * <property name="name" value="brown"></property>
	 * 
	 * </bean>
	 */
	
	@Bean
	public BoardService boardService() {
		BoardService boardService= new BoardService();
		boardService.setName("brown");
		boardService.setBoardDao(boardDao());
		
		return boardService;
	}
}
