package kr.or.ddit.board.service;

import kr.or.ddit.board.dao.IBoardDao;

public class BoardService implements IBoardService{
	
	private IBoardDao boardDao;
	private IBoardService boardService;
	private String name;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BoardService() {
	}


	public BoardService(IBoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public IBoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(IBoardService boardService) {
		this.boardService = boardService;
	}

	public IBoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(IBoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public String sayHello() {
		return boardDao.sayHello();
	}
	

}
