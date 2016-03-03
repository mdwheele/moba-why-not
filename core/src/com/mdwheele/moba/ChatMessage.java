package com.mdwheele.moba;

public class ChatMessage
{

    public String message;

    private ChatMessage() {};
    public ChatMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

}
