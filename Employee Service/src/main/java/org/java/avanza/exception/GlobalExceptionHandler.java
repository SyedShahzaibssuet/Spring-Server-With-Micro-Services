package org.java.avanza.exception;

import org.java.avanza.Data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Array;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(Resource)
    public ResponseEntity handleResourceNoFound(WebRequest req, List<User> conten)
    {
        ErrorDetails errors = new ErrorDetails();
        errors.setCode("0");
        errors.setContent(conten);
        errors.setMessage("Failed to Fetched User");
        return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
    }
    public ResponseEntity handleResourceFound(WebRequest req, List<User> conten)
    {
        ErrorDetails errors = new ErrorDetails();
        errors.setCode("1");
        errors.setContent(conten);
        errors.setMessage("Successfully fetched users");
        return new ResponseEntity(errors, HttpStatus.OK);
    }
}
