package org.mbc.domain;

import java.util.Date;

import lombok.Data; //생성자, getter, setter, toString 등 자동생성

@Data
public class BoardVO {
	
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
	
}
