package kr.or.ddit.batch.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.batch.model.BatchVo;
import kr.or.ddit.testenv.LogicTestEnv;


public class BatchDaoTest extends LogicTestEnv {
private static final Logger logger = LoggerFactory.getLogger(BatchDaoTest.class);
	@Resource(name = "batchDao")
	IBatchDao batchDao;
	
	@Test
	public void createDailyTest() {
		
		/***Given***/
		String ym = "201907";
		

		/***When***/
		int cnt = batchDao.createDaily(ym);

		/***Then***/
		assertEquals(69, cnt);
	}
	@Test
	public void deleteDailyTest() {
		/***Given***/
		String ym = "201907";
		batchDao.createDaily(ym);
		

		/***When***/
		
		int cnt = batchDao.deleteDaily(ym);
		

		/***Then***/
		assertEquals(69, cnt);
	}
	
	/**
	* Method : insertBatchTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 배치데이터 Insert 테스트
	*/
	@Test
	public void insertBatchTest() {
		/***Given***/
		BatchVo batchVo = new BatchVo();
		batchVo.setBcd("01"); // 일실적 배치
		batchVo.setSt("01"); //배치 실행상태 : 01 -진행중

		logger.debug("before batchVo.getBid : {}",batchVo.getBid());
		/***When***/
		int insertCnt = batchDao.insertBatch(batchVo);
		logger.debug("after batchVo.getBid : {}",batchVo.getBid());
		

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	
	/**
	* Method : updateBatchTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 배치데이터 업데이트 테스트
	*/
	@Test
	public void updateBatchTest() {
		/***Given***/
		BatchVo batchVo = new BatchVo();
		batchVo.setBcd("01"); // 일실적 배치
		batchVo.setSt("01"); //배치 실행상태 : 01 -진행중
		
		batchDao.insertBatch(batchVo);
		
		logger.debug("bid : {}",batchVo.getBid());
		
		batchVo.setSt("02"); //배치 실행상태 : 01 -진행중

		/***When***/
		int updateCnt = batchDao.updateBatch(batchVo);
		

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	

}
