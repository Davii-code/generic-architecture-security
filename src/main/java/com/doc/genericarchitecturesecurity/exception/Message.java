package com.doc.genericarchitecturesecurity.exception;

import com.doc.genericarchitecturesecurity.enums.MessageCode;
import com.doc.genericarchitecturesecurity.enums.MessageType;
import lombok.Data;

@Data
public class Message {
    private String message;

    private String code;
    private MessageType type;
    private Object[] params;

    public Message(MessageCode messageCode, Object... params) {
        this.type = messageCode.getType();
        this.code = messageCode.getCode();
        this.params = params;
    }

}
