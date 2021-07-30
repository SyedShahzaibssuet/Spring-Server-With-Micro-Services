package org.java.avanza.Controller;

import org.java.avanza.Data.entity.Employee;
import org.java.avanza.Data.entity.User;
import org.java.avanza.Model.EmployeeRegistrationModel;
import org.java.avanza.Model.EmployeeRegistrationUpdateModel;
import org.java.avanza.Model.RegistrationModel;
import org.java.avanza.Model.RegistrationUpdateModel;
import org.java.avanza.services.EmployeeService;
import org.java.avanza.services.Registrationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
//@RequestMapping("/Employee-Registration")
// When we have multiple controller we can set path for this controller
public class Registration {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity index(){
        List<Employee> users = employeeService.getallemployee();
        ResponseEntity responseentity =new ResponseEntity<>(users, HttpStatus.ACCEPTED);
        return responseentity;

    }
    @PostMapping("/Adduser")
    public ResponseEntity register(@RequestBody EmployeeRegistrationModel body){
        employeeService.addemployee(body);
        return new ResponseEntity<>("New user is Added to Database",HttpStatus.OK);
    }
    @PostMapping("/DeleteUser")
    public ResponseEntity deleteuser(@RequestBody EmployeeRegistrationUpdateModel regbody)
    {
        employeeService.deleteemployee(regbody);
        return new ResponseEntity<>("User is Deleted",HttpStatus.OK);
    }
    @PostMapping("/UpdateUser")
    public ResponseEntity updateuser(@RequestBody EmployeeRegistrationUpdateModel reqbody)
    {
        employeeService.updateemployee(reqbody);
        return new ResponseEntity<>(reqbody.getName()+" "+reqbody.getDepartment() +" is updated",HttpStatus.OK);
    }
}
