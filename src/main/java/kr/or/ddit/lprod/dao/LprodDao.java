package kr.or.ddit.lprod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

@Repository
public class LprodDao implements ILprodDao {
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;

	/**
	* Method : prodList
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 리스트
	*/
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		return sqlSession.selectList("lprod.lprodPagingList",pageVo);
	
	}

	@Override
	public int lprodCnt() {
		return sqlSession.selectOne("lprod.lprodCnt");
	}

	@Override
	public List<LprodVo> lprodList() {
		return sqlSession.selectList("lprod.lprodList");
	}
}
