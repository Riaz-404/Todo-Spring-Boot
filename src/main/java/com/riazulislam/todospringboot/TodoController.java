package com.riazulislam.todospringboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    public static List<Todo> todoList;

    public TodoController(){
        todoList = new ArrayList<>();

        todoList.add(new Todo(1, "Todo 1", false, 1));
        todoList.add(new Todo(2, "Todo 2", false, 1));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.ok(todoList);
    }

    @PostMapping
    public ResponseEntity<List<Todo>> createNewTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoList);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<?> updateTodo(@RequestBody Todo updatedTodo, @PathVariable long todoId){
        for(Todo todo: todoList){
            if(todo.getId() == todoId){
                todo.setId(updatedTodo.getId());
                todo.setTitle(updatedTodo.getTitle());
                todo.setCompleted(updatedTodo.isCompleted());
                todo.setUserId(updatedTodo.getUserId());
                return ResponseEntity.status(HttpStatus.OK).body(todoList);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable long todoId){
        for(Todo todo: todoList){
            if(todo.getId() == todoId){
                todoList.remove(todo);
                return ResponseEntity.status(HttpStatus.OK).body(todoList);
            }
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }
}
