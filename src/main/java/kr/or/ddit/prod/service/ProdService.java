package kr.or.ddit.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.model.ProdVo;

@Service
public class ProdService implements IProdService {
	
	@Resource(name="prodDao")
	private IProdDao prodDao;

	@Override
	public List<ProdVo> prodList(String code) {
		return prodDao.prodList(code);
	}
	
	

}
