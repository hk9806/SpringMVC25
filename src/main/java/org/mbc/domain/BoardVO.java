package org.mbc.domain;

import java.util.Date;

import lombok.Data; //생성자, getter, setter, toString 등 자동생성

@Data
public class BoardVO {
	//객체 전용, VO는 읽기전용 속성이 강함 (getter 위주 세팅)
	// DTO는 getter/setter 모두 가지고 활용하는 객체
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate; //import java.util.Date;
	private Date updateDate;
	
}
