package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.service.IBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/kr/or/ddit/ioc/application-ioc-test.xml")
public class SpringIocJUnitTest {

	@Resource(name="boardService")
	private IBoardService boardService;
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

		/***When***/
		String msg = boardService.sayHello();
		/***Then***/
		assertNotNull(boardService);
		assertEquals("boardDao sayHello", msg);
	}

}
