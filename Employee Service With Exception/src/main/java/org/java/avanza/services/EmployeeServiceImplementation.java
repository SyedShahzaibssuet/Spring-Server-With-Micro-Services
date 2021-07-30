package org.java.avanza.services;

import org.java.avanza.Data.entity.Employee;
import org.java.avanza.Data.repositry.EmployeeRepositry;
import org.java.avanza.Model.EmployeeRegistrationModel;
import org.java.avanza.Model.EmployeeRegistrationUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImplementation implements EmployeeService{
    @Autowired
    EmployeeRepositry employeeRepositry;

    @Override
    public void addemployee(EmployeeRegistrationModel employeeRegistrationModel) {
        Employee emp = new Employee();
        emp.setName(employeeRegistrationModel.getName());
        emp.setDepartment(employeeRegistrationModel.getDepartment());
        emp.setStatus(employeeRegistrationModel.getStatus());
        employeeRepositry.save(emp);
    }

    @Override
    public List<Employee> getallemployee() {
        List<Employee> allemp = employeeRepositry.findAll();
        return allemp;
    }

    @Override
    public void updateemployee(EmployeeRegistrationUpdateModel employeeRegistrationUpdateModel) {
        Optional<Employee> emp = employeeRepositry.findById(employeeRegistrationUpdateModel.getID());
        if(emp.isPresent()){
            emp.get().setName(employeeRegistrationUpdateModel.getName());
            emp.get().setDepartment(employeeRegistrationUpdateModel.getDepartment());
            emp.get().setStatus(employeeRegistrationUpdateModel.getStatus());
            employeeRepositry.save(emp.get());
        }
    }

    @Override
    public void deleteemployee(EmployeeRegistrationUpdateModel employeeRegistrationUpdateModel) {
        employeeRepositry.deleteById(employeeRegistrationUpdateModel.getID());
    }

    @Override
    public Employee getemployee(Integer empid) {
        Employee emp = employeeRepositry.getById(empid);
        return emp;
    }
}
