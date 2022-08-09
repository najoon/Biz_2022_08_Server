package com.callor.todo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service("todoServiceV1")
public class TodoServiceImplV1 implements TodoService{
	
	@Autowired
	private TodoDao todoDao;
	
	public TodoServiceImplV1() {
	this.todoDao = todoDao;
	}
	
	
	@Override
	public void create_todo_table() {
	todoDao.create_todo_table();
		
	}



	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		return todoDao.selectAll();
	}



	@Override
	public TodoVO findById(Long t_set) {
		// TODO Auto-generated method stub
		return todoDao.findById(t_set);
	}



	@Override
	public int insert(TodoVO vo) {
		return todoDao.insert(vo);
	}



	@Override
	public int update(TodoVO vo) {
		return todoDao.update(vo);
	}



	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int todoInsert(String t_todo) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
		String toDate = dateFormat.format(date);
		String toTime = timeFormat.format(date);
		
		TodoVO toVO = TodoVO.builder().t_date(toDate).t_time(toTime).t_todo(t_todo).build();
		return todoDao.insert(toVO);
	}









	

}