package org.mbc.controller;

import org.mbc.domain.BoardVO;
import org.mbc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller // url 분기와 jsp 연동을 담당
@Log4j2
@RequestMapping("/board/*") // http://192.168.111.104:80/board/* (모든경로)
@AllArgsConstructor // 생성자 자동주입 (모든 필드를 보고 생성자 생성)
public class BoardController {
	// 리스트와 CRUD를 담당하는 분기 설정 (url)

	private BoardService service; // 필드

	@GetMapping("/list") // http://192.168.111.104:80/board/list
	public void list(Model model) {
		// model은 스프링에서 데이터 관리용 객체 (request영역, session영역과 같은 의미)
		log.info("BoardController.list메소드 실행------------------------");
		model.addAttribute("list", service.getList());
		// 프론트에서 ${list}로 활용 (for문 사용)
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		// RedirectAttributes rttr 성공 후 이동할 경로를 기입

		log.info("BoardController.register메소드 실행-----------------");

		service.register(board); // 객체 등록 성공 여부
		// 성공 시 이동할 경로 배정
		rttr.addFlashAttribute("result", board.getBno());
		// 일회용 값을 생성 -> 이름: result (추후 프론트에서 alert 용으로 활용)

		return "redirect:/board/list"; // 성공 시 다음 페이지
	}

	@GetMapping("/get") // http://192.168.111.104:80/board/get?bno=5
	public void get(@RequestParam("bno") Long bno, Model model) {
		// url을 통해서 넘어온 bno=5문자열을 long 타입으로 받아 model 객체에 넣음.
		log.info("BoardController.get메소드 실행-----------------");

		model.addAttribute("board", service.get(bno));
		// 서비스에서 매퍼를 다녀와 객체를 가져온 것을 모델 객체에 넣음
		// 프론트에서는 ${board.bno} ${board.title} ${board.content} 출력 가능
	}

	@PostMapping("/modify") // http://192.168.111.104:80/board/modify
	public String modify(BoardVO board, RedirectAttributes rttr) {
		// 프론트에서 수정된 boardvo가 넘어오면 update쿼리가 실행되고 결과가 boolean으로 나옴
		log.info("BoardController.modify 메서드 실행--------------");

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			// 성공시 프론트에 result라는 일회용 값을 보냄
		}
		return "redirect:/board/list";
	}

	@PostMapping("/remove") // http://192.168.111.104:80/board/remove
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		// 프론트에서 삭제할 번호가 넘어오면 delete쿼리가 실행되고 결과가 boolean으로 나옴
		log.info("BoardController.remove 메소드-----------------------");

		if (service.remove(bno)) {
			// 서비스에 다녀온 결과가 true면 아래 실행문을 실행
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list"; // 처리 후 이동 페이지
	}
}
