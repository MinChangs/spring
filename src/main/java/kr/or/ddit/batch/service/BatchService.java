package kr.or.ddit.batch.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.batch.dao.IBatchDao;
import kr.or.ddit.batch.model.BatchVo;

@Service
public class BatchService implements IBatchService {
	
	@Resource(name = "batchDao")
	private IBatchDao batchDao;


	@Override
	public int createDaily(String ym) {
		//배치정보 생성
		BatchVo batchVo = new BatchVo();
		batchVo.setBcd("01"); //배치구분코드 01 일실적 배치
		batchVo.setSt("01");//배치 상태 코드 01 진행중
		batchDao.insertBatch(batchVo);
		
		
		batchDao.deleteDaily(ym);
		int insertCnt = batchDao.createDaily(ym);
		
		batchVo.setSt("02");
		batchDao.updateBatch(batchVo);
		return insertCnt;
	}
}
