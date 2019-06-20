package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.service.IBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/kr/or/ddit/ioc/application-ioc-test.xml")
public class SpringIocJUnitTest {

	@Resource(name = "boardDao")
	private IBoardDao boardDao;

	@Resource(name = "boardDaoPrototype")
	private IBoardDao boardDaoPrototype;

	@Resource(name = "boardDaoPrototype")
	private IBoardDao boardDaoPrototype2;

	
	
	
	@Resource(name = "boardService")
	private IBoardService boardService;

	@Resource(name = "boardService")
	private IBoardService boardService2;

	@Resource(name = "boardServiceConstruction")
	private IBoardService boardServiceConstruction;

	
	/**
	* Method : springIocRest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 스프링 컨테이너 생성 테스트
	*/
	@Test
	public void springIocTest() {

		/*** Given ***/

		/*** When ***/
		String msg = boardService.sayHello();
		/*** Then ***/
		assertNotNull(boardService);
		assertEquals("boardDao sayHello", msg);
	}


	/**
	* Method : springSingletonScopeRest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 :스프링 컨테이너 생성
	*/
	@Test
	public void springSingletonScopeTest() {
		
		// field 기준 boardService, boardService2 : spring boardService
		// bean(scope=singleton)
		// boardServiceConstruction : spring boardServiceConstruction
		// bean(scope=singleton)
		// 1. boardService, boardService2 : 같아야함
		// 2. boardService, boardServiceConstruction : 같은 클래스에서 만들어진 객체이지만 spring
		// singleton개념에 따라 다른 객체
		// 3. boardService2, boardServiceConstruction : 같은 클래스에서 만들어진 객체이지만 spring
		// singleton개념에 따라 다른 객체

		/*** Given ***/

		/*** When ***/

		/*** Then ***/
		assertNotNull(boardService);
		assertNotNull(boardService2);
		assertNotNull(boardServiceConstruction);
		assertEquals(boardService, boardService2);
		assertNotEquals(boardService, boardServiceConstruction);
		assertNotEquals(boardService2, boardServiceConstruction);
		

	}
	
	
	
	
	/**
	* Method : springPrototypeScopeTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : PrototypeScopeTest
	*/
	@Test
	public void springPrototypeScopeTest() {
		
		//boardDao : spring boardDao(scope = singleton)
		//boardDaoPrototype : spring boardDaoPrototype(scope = prototype)
		//boardDaoPrototype2 : spring boardDaoPrototype(scope = prototype)
		//1. boardDao boardDaoPrototype : spring bean id가 다르므로 다른객체
		//2. boardDaoPrototype, boardDaoPrototype2 : 두 객체는 같은 스프링 빈이지만 scope가 prototype이므로 다른객체이어야한다. 

		/*** Given ***/

		/*** When ***/

		/*** Then ***/

		assertNotNull(boardDao);
		assertNotNull(boardDaoPrototype);
		assertNotNull(boardDaoPrototype2);
		assertNotEquals(boardDao, boardDaoPrototype);
		assertNotEquals(boardDaoPrototype, boardDaoPrototype2);

	}
}
