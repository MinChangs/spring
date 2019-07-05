package kr.or.ddit.aop;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.testenv.LogicTestEnv;

@ContextConfiguration("classpath:kr/or/ddit/aop/application-aop-scan.xml")
public class AopScanTest extends LogicTestEnv {
	@Resource(name = "boardService")
	private IBoardService boardService;
	


	@Test
	public void aopBeforeTest() {
		/***Given***/
		

		/***When***/
		String msg = boardService.sayHello();
		
		/***Then***/
		assertEquals("boardDao sayHello", msg);
	}
	
	

	
	

}
