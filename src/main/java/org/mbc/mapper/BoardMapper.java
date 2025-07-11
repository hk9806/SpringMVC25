package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	// interface는 클래스와 다르게 메소드가 추상화처럼 되어있음
	// 추상메소드는 시그니쳐만 있으면 {실행문이 없음.} 세미콜론 사용하여 종료

	// 어노테이션으로 간단한 쿼리문은 가능하나 복잡한 쿼리문은 버그가 좀 있음.
	@Select("SELECT * FROM tbl_board WHERE bno > 0") 
	//bno > pk로 선언되어있기에 인덱싱으로 빠른 추출 가능
	
	public List<BoardVO> getList(); // 추상 메소드

	//xml 이용하여 sql문 처리를 진행
	//xml 이용하려면 src/main/resources -> org -> mbc -> mapper 폴더를 만들고
	//인터페이스와 이름이 같은 xml파일을 생성
	// 마이바티스 사용법.

	public List<BoardVO> getList2();
	//xml 이용한 쿼리 처리 매퍼용 메소드
	
	//c: insert 데이터를 삽입하는 쿼리문
	// 1. insert 처리 후 결과 int로 받는 방법
	// 2. pk를 먼저 생성 후 insert 되는 방법
	public void insert(BoardVO board); //xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board); //xml에서 쿼리 작성
	
	public BoardVO read(Long bno); //xml에서 쿼리 작성
	// 번호가 들어가면 객체로 나옴.

	public int delete(Long bno); //번호가 들어가면 삭제 후 삭제된 행 수 만큼 리턴
	
	public int update(BoardVO board); // xml에서 쿼리 작성
	// 번호가 들어가면 필드 수정 후 수정된 수 리턴
}
