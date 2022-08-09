package com.callor.todo.persistance;

import javax.swing.Spring;

import com.callor.todo.model.TodoVO;

public interface TodoDao extends GenericDao<TodoVO, Long> {

	public void create_todo_table();
	public TodoVO findById(Long t_seq);
	public int todoInsert(String toVO);
}
