package com.example.gp;

import java.util.ArrayList;

public class Doctor
{
    private String name;
    private String specialty;
    private String email;
    private String contactNo;
    private String empId;

    // constructor to create a new Doctor object
    public Doctor(String name, String specialty, String email, String contactNo, String empId)
    {
        this.name = name;
        this.specialty = specialty;
        this.email = email;
        this.contactNo = contactNo;
        this.empId = empId;
    }
    // This method returns the name of the doctor
    public String getName()
    {
        return name;
    }

// This method returns the specialty of the doctor
    public String getSpecialty()
    {
        return specialty;
    }

// This method returns the email address of the doctor
    public String getEmail()
    {
        return email;
    }

// This method returns the contact number of the doctor
    public String getContactNo()
    {
        return contactNo;
    }

// This method returns the employee ID of the doctor
    public String getEmpId()
    {
        return empId;
    }

// This method overrides the default toString method to provide a string representation of the Doctor object
    @Override
    public String toString() {
        return "{" +
                "Doctor='" + name + '\'' +
                "\nSpecialty='" + specialty + '\'' +
                "\nEmail='" + email + '\'' +
                "\nContact No='" + contactNo + '\'' +
                "\nID='" + empId + '\'' +
                '\n';
    }
}
