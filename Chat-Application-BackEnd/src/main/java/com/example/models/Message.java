package com.example.models;

public class Message {

    private String username;
    private String content;
    private String time;

    public Message() {
    }

    public Message(String username, String content, String time) {
        this.username = username;
        this.content = content;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
