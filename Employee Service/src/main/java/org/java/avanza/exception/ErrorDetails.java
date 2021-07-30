package org.java.avanza.exception;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.java.avanza.Data.entity.User;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.List;
public class ErrorDetails {
    private String code;
    private List<User> content;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<User> getContent() {
        return content;
    }

    public void setContent(List<User> content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
