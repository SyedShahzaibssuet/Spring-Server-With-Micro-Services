package org.java.avanza.exception;

import org.apache.el.stream.Optional;
import org.java.avanza.Data.entity.Employee;
import org.java.avanza.Model.EmployeeRegistrationModel;
import org.java.avanza.Model.EmployeeRegistrationUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    ErrorDetails errors;
    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity handleResourceNoFound()
    {
        List<Employee> lists;
        lists = null;
        errors.setCode("0");
        errors.setContent(lists);
        errors.setMessage("Failed to Compelete Process");
        return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleResourceFound(List<Employee> conten,String message)
    {
        ErrorDetails errors = new ErrorDetails();
        errors.setCode("1");
        errors.setContent(conten);
        errors.setMessage(message);
        return new ResponseEntity(errors, HttpStatus.OK);
    }
}
