package com.example.gp;

import java.time.LocalTime;

// This class represents an appointment
public class Appointment
{
    private String reference;
    private String date;
    private LocalTime time;
    private Patient patient;
    private Doctor doctor;
    private String description;

    // This constructor creates a new Appointment object with the given parameters and initialises the appointment fields
    public Appointment (String id, String date, Patient patient, Doctor doctor, String description, LocalTime time)
    {
        // Assign the appointment details to the corresponding fields
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.description = description;
        this.time = time;
        this.reference = id;
    }
    // This method returns the patient who booked the appointment
    public Patient getPatient() {
        return patient;
    }
    // This method returns a string representation of the appointment object with its details
    @Override
    public String toString() {
        return // reference +
                "Date:'" + date + '\'' +
                "\nTime:" + time + '\'' +
                "\nPatient:" + patient.getName() +
                "\nDoctor:" + doctor.getName() +
                "\nDescription:'" + description + '\'' +
                '\n';
    }
}
