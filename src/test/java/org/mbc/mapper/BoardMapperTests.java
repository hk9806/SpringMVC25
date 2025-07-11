package org.mbc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mbc.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
	//board에서 사용하는 데이터베이스 테스트
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper; //인터페이스로 만든 객체를 세터로 연결
	
	@Test //메소드 단위로 테스트
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board));
	  //인터페이스.메소드.for문		결과객체 -> log.info 콘솔에 출력(board.toString)
	  //							   ->:람다식 (인터페이스용)
	}
	
	@Test
	public void testGetListXML() {
		mapper.getList2().forEach(board -> log.info(board));
		//인터페이스.메소드.for문		결과객체 -> log.info 콘솔에 출력(board.toString)
		  //							   ->:람다식 (인터페이스용)
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("오류 없음");
		board.setContent("누구");
		board.setWriter("kkw");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("aaa");
		board.setContent("bbb");
		board.setWriter("aaa");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
		log.info("작성한 게시물 번호: "+board.getBno());	
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(1L); //1번 게시물을 read메소드로 보내고 객체로 받음
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		
		int count = mapper.delete(3L);
		log.info("삭제된 게시글 수: "+count+" 건");
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(5L);
		board.setTitle("수정된제목");
		board.setContent("수정된내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("수정된 개수: "+count);
	}
}
