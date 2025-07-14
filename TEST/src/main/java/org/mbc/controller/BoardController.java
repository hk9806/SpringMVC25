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

@Controller 
@Log4j2
@RequestMapping("/board/*") 
@AllArgsConstructor 
public class BoardController {
	

	private BoardService service; 

	@GetMapping("/list") 
	public void list(Model model) {
		
		log.info("BoardController.list메소드 실행------------------------");
		model.addAttribute("list", service.getList());
	
		
		
	}
	
	@GetMapping("/register")
	public String register() {
		return "/board/register";
	}
	

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		

		log.info("BoardController.register메소드 실행-----------------");

		service.register(board); 
	
		rttr.addFlashAttribute("result", board.getBno());
		

		return "redirect:/board/list"; 
	}

	@GetMapping({"/get","/modify"}) 
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		
		
		log.info("BoardController.get메소드 실행-----------------");

		model.addAttribute("board", service.get(bno));
		
	}

	@PostMapping("/modify") 
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		log.info("BoardController.modify 메서드 실행--------------");

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			
		}
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		log.info("BoardController.remove 메소드-----------------------");

		if (service.remove(bno)) {
			
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list"; 
	}
}
