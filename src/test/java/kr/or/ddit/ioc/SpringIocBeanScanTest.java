package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.service.IBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-bean-scan.xml")
public class SpringIocBeanScanTest {

	//<bean 태그를 이용하여 스프링 bean을 등록하는 방식을 사용하지 않고 
	// @Controller, @Service, @Repository 어노테이션을 적용한 클래스를
	// base package 하위 모든 클래스를 scan하여 스프링 빈으로 등록
	
	
	//boardDao, boardService 스프링 빈이 정상적으로 생성되었는디
	@Resource(name = "boardDao")
	private IBoardDao boardDao;
	
	@Resource(name ="boardService")
	private IBoardService boardService;
	
	@Test
	public void iocBeanScanTest() {
		
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(boardDao);
		assertNotNull(boardService);
		assertEquals("boardDao sayHello", boardDao.sayHello());
		assertEquals(boardService.getBoardDao(), boardDao);
		
		
	}

}
