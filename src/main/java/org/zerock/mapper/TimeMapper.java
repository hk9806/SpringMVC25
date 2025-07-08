package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//인터페이스는 추상메소드를 사용
	//추상메소드 : 메소드명만 존재, 실행문이 없음.
	//사용: 클래스에 implements 인터페이스명을 사용
	
	@Select("SELECT sysdate FROM dual") //주의사항: 세미콜론 제외
	public String getTime();
	//인터페이스에 선언된 메소드는 추상메소드로 실행문이 없음
	// 관례: sql 쿼리문은 대문자로 쓰는게 관례

	public String getTime2();//추상 메소드
	//이 메소드가 호출되면 마이바티스에서 xml을 찾음
	//src/main/resources/org.zerock.mapper/TimeMapper.xmlW
}
