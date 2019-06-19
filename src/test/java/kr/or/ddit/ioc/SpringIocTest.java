package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.or.ddit.board.service.IBoardService;

public class SpringIocTest {

	/**
	 * 
	* Method : sptingIocRest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 스프링 컨테이너 생성 테스트
	 */
	@Test
	public void sptingIocRest() {
		
		/***Given***/
		// 스프링 컨테이너 생성
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:/kr/or/ddit/ioc/application-ioc-test.xml");
		
		/***When***/
		IBoardService boardService= (IBoardService)context.getBean("boardService");
		String msg = boardService.sayHello();
		/***Then***/
		assertNotNull(boardService);
		assertEquals("boardDao sayHello", msg);
	}

}
