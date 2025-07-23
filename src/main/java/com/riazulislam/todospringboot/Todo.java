package com.riazulislam.todospringboot;

public class Todo {
    private long id;
    private String title;
    private boolean completed;
    private long userId;

    public Todo(long id, String title, boolean completed, long userId) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
