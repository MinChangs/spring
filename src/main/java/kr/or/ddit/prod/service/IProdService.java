package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

public interface IProdService {
	List<ProdVo> prodList(String code);
}
