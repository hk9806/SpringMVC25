package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service // 해당 클래스는 서비스 계층임을 명시
@AllArgsConstructor // 생성자 자동 주입 (new BoardServiceImpl(mapper);
@Log4j2 // 로깅 처리용
public class BoardServiceImpl implements BoardService {
	// 조원이 실행문을 생성하는 용도 활용 필수: implements BoardService(구현클래스)

	private BoardMapper mapper; // DB 쿼리용 객체(CRUD)

	@Override
	public void register(BoardVO board) {
		// 객체가 넘어오면 매퍼를 이용해서 데이터베이스에 등록

		log.info("BoardServiceImpl.register 메소드실행-----------------");
		mapper.insertSelectKey(board);

		log.info("정상등록 후 리스트 출력 테스트--------------------");
		mapper.getList2();
	}

	@Override
	public BoardVO get(Long bno) {
		// 게시물의 번호가 들어가면 메퍼의 select문이 동작
		log.info("BoardServiceImpl.get 메소드 실행----------------------");

		return mapper.read(bno);
	}

	@Override
	public Boolean modify(BoardVO board) {
		// 프론트에서 객체가 넘어오면 메퍼를 통해서 update쿼리 실행
		log.info("BoardServiceImpl.modify 메소드 실행----------------------");

		return mapper.update(board) == 1;
	}

	@Override
	public Boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete쿼리 실행
		log.info("BoardServiceImpl.delete 메소드 실행----------------------");

		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// getLis() 메소드가 호출되면 메퍼에 getList2()를 호출

		log.info("BoardServiceImpl.getList 메소드 실행------------------");
		return mapper.getList2();
	}

}
