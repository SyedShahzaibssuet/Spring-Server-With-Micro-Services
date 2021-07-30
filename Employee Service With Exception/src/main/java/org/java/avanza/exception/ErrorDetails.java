package org.java.avanza.exception;

import org.java.avanza.Data.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ErrorDetails {
    private String code;
    private List<Employee> content;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Employee> getContent() {
        return content;
    }

    public void setContent(List<Employee> content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
