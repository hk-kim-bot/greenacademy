package com.tt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tt.demo.service.BoardService;
@Controller
public class boardcontroller {
	@Autowired
	private BoardService boardservice;
	
	
	
	
	@GetMapping({"","/"})
	public String index(Model model,@PageableDefault(size=3,sort="id",direction= Sort.Direction.DESC)Pageable pageable) {
		model.addAttribute("boards",boardservice.글목록(pageable));
		return "index";
	}
	@GetMapping({"/board/saveForm"})
	public String saveForm() {
		return "board/saveForm";
	}
	@GetMapping("/board/{id}")
	public String findbyid(@PathVariable int id,Model model) {
		model.addAttribute("board",boardservice.글상세보기(id));
		return "board/detail";
	}
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id,Model model) {
		model.addAttribute("board",boardservice.글상세보기(id));
		return "board/updateForm";
	}
	@GetMapping("/board/search")
	public String searchcontent(@RequestParam(value="keyword")String keyword,Model model) {
		model.addAttribute("board", boardservice.searchpost(keyword));
		return "index";
	}
}
