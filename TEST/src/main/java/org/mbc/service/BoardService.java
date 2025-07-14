package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;

public interface BoardService {
	
	
	public void register(BoardVO board); 
	
	
	public BoardVO get(Long bno); 
	
	
	public Boolean modify(BoardVO board);
	
	
	public Boolean remove(Long bno);
	
	
	public List<BoardVO> getList();
	
	
	
	
	
}
