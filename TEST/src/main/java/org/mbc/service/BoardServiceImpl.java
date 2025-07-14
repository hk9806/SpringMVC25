package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service 
@AllArgsConstructor
@Log4j2 
public class BoardServiceImpl implements BoardService {
	

	private BoardMapper mapper; 

	@Override
	public void register(BoardVO board) {
		

		log.info("BoardServiceImpl.register 메소드실행-----------------");
		mapper.insertSelectKey(board);

		log.info("정상등록 후 리스트 출력 테스트--------------------");
		mapper.getList2();
	}

	@Override
	public BoardVO get(Long bno) {
		
		log.info("BoardServiceImpl.get 메소드 실행----------------------");

		return mapper.read(bno);
	}

	@Override
	public Boolean modify(BoardVO board) {
		
		log.info("BoardServiceImpl.modify 메소드 실행----------------------");

		return mapper.update(board) == 1;
	}

	@Override
	public Boolean remove(Long bno) {
		
		log.info("BoardServiceImpl.delete 메소드 실행----------------------");

		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		

		log.info("BoardServiceImpl.getList 메소드 실행------------------");
		return mapper.getList2();
	}

}
