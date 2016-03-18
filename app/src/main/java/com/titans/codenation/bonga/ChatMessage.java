package com.titans.codenation.bonga;

/**
 * Created by joseph on 3/18/16.
 */
public class ChatMessage {

    private String author;
    private String message;


    public ChatMessage(){

    }

    public ChatMessage(String author, String message){
        this.message = message;
        this.author = author;
    }

    //required by firebase for serializig and de-serializing
    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
