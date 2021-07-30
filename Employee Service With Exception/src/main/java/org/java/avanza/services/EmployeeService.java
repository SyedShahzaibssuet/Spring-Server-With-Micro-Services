package org.java.avanza.services;

import org.java.avanza.Data.entity.Employee;
import org.java.avanza.Model.EmployeeRegistrationModel;
import org.java.avanza.Model.EmployeeRegistrationUpdateModel;

import java.util.List;

public interface EmployeeService {
    void addemployee(EmployeeRegistrationModel employeeRegistrationModel);
    List<Employee> getallemployee();
    void updateemployee(EmployeeRegistrationUpdateModel employeeRegistrationUpdateModel);
    void deleteemployee(EmployeeRegistrationUpdateModel employeeRegistrationUpdateModel);
    Employee getemployee(Integer empid);
}
