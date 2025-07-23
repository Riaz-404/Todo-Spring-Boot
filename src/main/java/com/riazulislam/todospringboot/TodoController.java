package com.riazulislam.todospringboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
