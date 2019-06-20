package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.collection.IocCollection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/kr/or/ddit/ioc/application-ioc-collection.xml")
public class SpringIocCollectionTest {

	@Resource(name = "collectionBean")
	private IocCollection ic;
	@Test
	public void test() {
		/***Given***/
		

		/***When***/
		List<String>list = ic.getList();
		Map<String, String>map=ic.getMap();
		Set<String> set=ic.getSet();
		Properties properties = ic.getProperties();
		

		/***Then***/
		assertNotNull(list);
		assertNotNull(map);
		assertNotNull(set);
		assertNotNull(properties);
		assertEquals(3, list.size());
		assertEquals("sally", list.get(1));
		assertEquals("brown", map.get("name"));
		assertEquals(3, set.size());
		assertTrue(set.contains("brown")); 
		assertEquals("브라운", properties.get("name"));
		
	}

}
