package org.java.avanza.Controller;

import org.java.avanza.Data.entity.Employee;
import org.java.avanza.Model.EmployeeRegistrationModel;
import org.java.avanza.Model.EmployeeRegistrationUpdateModel;
import org.java.avanza.exception.GlobalExceptionHandler;
import org.java.avanza.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/EmployeeService")
public class Registration {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    GlobalExceptionHandler globalExceptionHandler;

    @GetMapping("/")
    public ResponseEntity index(){
        List<Employee> emp = employeeService.getallemployee();
        if(emp.isEmpty())
        {
            return globalExceptionHandler.handleResourceNoFound();
        }
        else
        {
            return globalExceptionHandler.handleResourceFound(emp,"Successfully Fetched Employee's Record");
        }
    }

    @PostMapping("/Addemployee")
    public ResponseEntity register(@RequestBody EmployeeRegistrationModel body){
        if(body==null)
        {
            return globalExceptionHandler.handleResourceNoFound();
        }
        else
        {
            employeeService.addemployee(body);
            List<Employee> emp = employeeService.getallemployee();
            return globalExceptionHandler.handleResourceFound(emp,"Successfully Added New Employee Record");
        }
    }
    @PostMapping("/Deletemployee")
    public ResponseEntity deleteuser(@RequestBody EmployeeRegistrationUpdateModel regbody)
    {
        if(regbody==null)
        {
            return globalExceptionHandler.handleResourceNoFound();
        }
        else
        {
            employeeService.deleteemployee(regbody);
            List<Employee> emp = employeeService.getallemployee();
            return globalExceptionHandler.handleResourceFound(emp,"Successfully Deleted Employee Record");
        }
    }
    @PostMapping("/Updatemployee")
    public ResponseEntity updateemplyee(@RequestBody EmployeeRegistrationUpdateModel reqbody)
    {
        if(reqbody==null)
        {
            return globalExceptionHandler.handleResourceNoFound();
        }
        else
        {
            employeeService.updateemployee(reqbody);
            List<Employee> emp = employeeService.getallemployee();
            return globalExceptionHandler.handleResourceFound(emp,"Successfully Updated Employee Record");
        }
    }
    @PostMapping("/employee/{empid}")
    public ResponseEntity getemployee(@PathVariable Integer empid)
    {
        Employee emp=employeeService.getemployee(empid);
        List<Employee> emplist=null ;
        emplist.add(emp);
        if(emp==null)
        {
            return globalExceptionHandler.handleResourceNoFound();
        }
        else
        {
            return globalExceptionHandler.handleResourceFound(emplist,"Successfully Get Required Employee");
        }
    }
}
