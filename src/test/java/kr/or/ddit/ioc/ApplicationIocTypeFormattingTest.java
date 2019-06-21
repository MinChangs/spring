package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.typeConvert.model.FormattingVo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-formatting.xml")
public class ApplicationIocTypeFormattingTest {
	
	@Resource(name = "formattingVo")
	FormattingVo formattingVo;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");

	private static final Logger logger = LoggerFactory.getLogger(ApplicationIocTypeFormattingTest.class);
	@Test
	public void typeFormatting() {
		/***Given***/
		

		/***When***/
		logger.debug("sdf.format(formattingVo.getReg_dt()) : {}", sdf.format(formattingVo.getReg_dt()));
		logger.debug("formattingVo.getMod_dt()) : {}", formattingVo.getMod_dt());

		/***Then***/
		assertNotNull(formattingVo);
		assertEquals("2019-06-21", sdf.format(formattingVo.getReg_dt()));
		assertEquals("06-21-2019", sdf2.format(formattingVo.getMod_dt()));
		assertEquals(6000, formattingVo.getNumber());
	}

}
