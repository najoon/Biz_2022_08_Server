package com.callor.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/list")
public class TodoController {
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping(value="/todoList",method=RequestMethod.GET)
	public String todoList(Model model) {
		List<TodoVO> list = new ArrayList<TodoVO>();
		list = todoService.selectAll();
		model.addAttribute("TODOLIST",list);
		
		return "list/todoList";
		
	}
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input(Model model, TodoVO toVO) {
		
		
		return "list/input";
		
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String input(String t_todo) {
		log.debug("메모정보{}", t_todo);
		todoService.todoInsert(t_todo);
		return "redirect:/list/todoList";
	
	}
	
	@RequestMapping(value="/{t_seq}/update",method=RequestMethod.GET)
	public String update(@PathVariable("t_seq") long t_seq, Model model) {

		TodoVO todo = todoService.findById(t_seq);
		log.debug("여기입니다" + todo.toString());
		model.addAttribute("TODO", todo);
		return "list/update";
	}
	@RequestMapping(value="/{t_seq}/update",method=RequestMethod.POST) 
	public String update(
			@PathVariable("t_seq") long t_seq,
			 String t_todo) {
		TodoVO todo = todoService.findById(t_seq);
		
		todo.setT_todo(t_todo);
		todoService.update(todo);
		
		return "redirect:/list/todoList";
	}
	
	
	

}
