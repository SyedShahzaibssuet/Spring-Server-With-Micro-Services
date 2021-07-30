package org.java.avanza.Data.repositry;

import org.java.avanza.Data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee,Integer> {
}
