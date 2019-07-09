package kr.or.ddit.batch.service;

public interface IBatchService {
	
	/**
	* Method : createDaily
	* 작성자 : PC24
	* 변경이력 :
	* @param ym
	* @return
	* Method 설명 : 해당 년월의 일실적 일괄생성
	*/
	int createDaily(String ym);
}
