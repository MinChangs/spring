package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-convert.xml")
public class ApplicationIocTypeConvertTest {

	//userVo라는 이름의 스프링 빈이 정상적으로 생성되었는지 확인
	@Resource(name = "userVo")
	UserVo userVo;
	@Test
	public void typeInjectionTest() {
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		/***When***/

		/***Then***/
		assertNotNull(userVo);
		assertEquals("brown", userVo.getUserId());
		assertEquals("2019-08-08", sdf.format(userVo.getBirth()));
	}

}
