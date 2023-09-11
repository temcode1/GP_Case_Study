package com.example.gp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Patient
{
    // The patient's name
    private String name;
    // The patient's email address
    private String email;
    // The patient's contact number
    private String contactNo;
    // The patient's unique identification number
    private String patientID;
    // The patient's date of birth
    private String dob;

    // Constructor to create a new Patient object
    public Patient(String name, String email, String contactNo, String patientID, String dob)
    {
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.patientID = patientID;
        this.dob = dob;
    }

// This method returns the name of the patient
    public String getName() {
        return name;
    }

// This method returns the email address of the patient
    public String getEmail() {
        return email;
    }

// This method returns the contact number of the patient
    public String getContactNo() {
        return contactNo;
    }

// This method returns the unique identification number of the patient
    public String getPatientID() {
        return patientID;
    }

// This method returns the date of birth of the patient
    public String getDob() {
        return dob;
    }

    // This method overrides the default toString method to provide a string representation of the Patient object
    @Override
    public String toString() {
        return "" +
                "Patient='" + name + '\'' +
                "\nEmail='" + email + '\'' +
                "\nContact No='" + contactNo + '\'' +
                "\nPatient ID='" + patientID + '\'' +
                "\nDate of Birth='" + dob + '\'' +
                '\n';
    }
}
