package kr.or.ddit.aop;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.service.IBoardService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/aop/application-aop-scan.xml")
public class AopScanTest {
	@Resource(name = "boardService")
	private IBoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(AopScanTest.class);

	@Test
	public void aopBeforeTest() {
		/***Given***/
		

		/***When***/
		logger.debug("boardService.sayHello() : {}", boardService.sayHello());
		String msg = boardService.sayHello();
		
		/***Then***/
		assertEquals("boardDao sayHello", msg);
	}
	
	

	
	

}
