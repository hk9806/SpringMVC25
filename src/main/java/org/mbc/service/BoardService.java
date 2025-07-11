package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;

public interface BoardService {
	// 인터페이스는 단독으로 사용 불가능한 객체
	// 여기서 선언한 메소드는 무조건 추상메소드로 사용 (실행문 없음)
	// 인터페이스를 사용하려면 구현 클래스를 만든 후 실행문을 넣음
	// 인터페이스를 사용하는 이유는 관리자가 메소드 명을 강제로 세팅하기 위함
	
	public void register(BoardVO board); // 관리자가 만든 메소드명(시그니쳐)
	// 게시판 등록용 메소드
	
	public BoardVO get(Long bno); 
	// 게시글 자세히 보기 번호를 넣으면 객체 출력
	
	public Boolean modify(BoardVO board);
	// 게시글 수정 (객체가 들어가서 수정 됐는지 t/f)
	
	public Boolean remove(Long bno);
	// 게시글 삭제 (번호가 들어가서 삭제 됐는지 t/f)
	
	public List<BoardVO> getList();
	// 메서드가 호출되면 리스트 타입으로 BoardVO 객체들이 넘어옴
	// List: 동적 리스트/ < >제네릭: 강제로 객체 타입 지정 
	
	
	
	
}
