package com.gmail.karpovych.springdemoboot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "employee", schema = "kino_cms")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name = "employee_position_id")
    private Integer employeePositionId;
    @Column(name = "employee_cinema_id")
    private Integer employeeCinemaId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_surname")
    private String employeeSurname;
    @Column(name = "employee_age")
    private Integer employeeAge;
    @Column(name = "employee_sex")
    private String employeeSex;
    @Column(name = "employee_address")
    private String employeeAddress;
    @Column(name = "employee_phone_number")
    private String employeePhoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return employeeId != null && Objects.equals(employeeId, employee.employeeId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
