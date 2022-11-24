package com.fullstack.webservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter=0;//setting counter for id for each list added increment id by 1
	static {
		todos.add(new Todo(++idCounter,"kishore","Learn java",new Date(), false));
		todos.add(new Todo(++idCounter,"kishore","Learn angular",new Date(), false));
		todos.add(new Todo(++idCounter,"kishore","Learn springboot",new Date(), false));
	}
   
	public List<Todo> findAll(){//method to get all the todos
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());//deletes the specific id and adds the new one in
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo==null) return null;
		
		if(todos.remove(todo)) {
			return todo;
		}
		
		return null;
	}
	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		
		return null;
	}
}
