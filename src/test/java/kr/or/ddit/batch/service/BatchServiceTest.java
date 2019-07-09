package kr.or.ddit.batch.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;


public class BatchServiceTest extends LogicTestEnv {

	@Resource(name = "batchService")
	IBatchService batchService;
	
	@Test
	public void createDailyTest() {
		
		/***Given***/
		String ym = "201907";
		

		/***When***/
		int cnt = batchService.createDaily(ym);

		/***Then***/
		assertEquals(69, cnt);
	}

	
	

}
