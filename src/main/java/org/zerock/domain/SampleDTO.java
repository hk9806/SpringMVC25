package org.zerock.domain;

import lombok.Data;

@Data //lombok이 DTO를 관리함.
public class SampleDTO {

	//자바빈즈 규약
	//1. 필드는 private
	//2. 생성자는 기본생성자 필수
	//3. getter/setter 사용
	// lombok 이용 시 자동 생성
	
	private String name;
	private int age;
	
}
