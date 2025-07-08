package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component	// 스프링 의존성 처리 요청
@Data	//import lombok.Data; dto처리용 (get,set, toString, equals ,등)
public class Chef {
	private String name;
	private int age;
	
}
