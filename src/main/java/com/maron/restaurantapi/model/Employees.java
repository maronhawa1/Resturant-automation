package com.maron.restaurantapi.model;

public class Employees {
private Long id_employee;
private String name_employee;
private  String email_employee;
private String phone_employee;
private String ROLE_employee;
public Employees(Long id_employee,String name_employee,String email_employee,String phone_employee,String ROLE_employee){
    this.id_employee=id_employee;
    this.name_employee=name_employee;
    this.email_employee=email_employee;
    this.phone_employee=phone_employee;
    this.ROLE_employee=ROLE_employee;
}
public Long getId_employee(){
    return  id_employee;
}
public void setId_employee(Long UpdateID){
    this.id_employee=UpdateID;
}

    public String getName_employee() {
        return name_employee;
    }

    public void setName_employee(String name_employee) {
        this.name_employee = name_employee;
    }

    public String getEmail_employee() {
        return email_employee;
    }

    public void setEmail_employee(String email_employee) {
        this.email_employee = email_employee;
    }

    public String getPhone_employee() {
        return phone_employee;
    }

    public void setPhone_employee(String phone_employee) {
        this.phone_employee = phone_employee;
    }

    public String getROLE_employee() {
        return ROLE_employee;
    }

    public void setROLE_employee(String ROLE_employee) {
        this.ROLE_employee = ROLE_employee;
    }
}
