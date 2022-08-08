package com.callor.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/list")
public class TodoController {
	UserService userService;

	@RequestMapping(value="/todoList",method=RequestMethod.GET)
	public String todoList(Model model) {

		
		return "list/todoList";
		
	}
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input(Model model, TodoVO toVO) {
		
		
		return "list/input";
		
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String input(TodoVO toVO) {
	
		userService.todoInsert(toVO);
		return "redirect:/";
	
	}
	
	

}
