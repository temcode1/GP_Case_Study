package com.example.gp;
// Import necessary libraries and classes
import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
// Import the ArrayList class from the java.util package, which is a part of the Collection classes in Java
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


public class menu
{
    public static void main(String args[])
    {
        char choice;
        ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        ArrayList<Appointment> appList = new ArrayList<>();
        // Create files if they don't exist
        createFiles();
        // Initialise lists with data from files
        initialiseLists(doctorList, patientList, appList);
        // Display menu and accept user input
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("[1] Add Doctor");
            System.out.println("[2] Display Doctors");
            System.out.println("[3] Add Patient");
            System.out.println("[4] Display Patients");
            System.out.println("[5] Create Appointment");
            System.out.println("[6] Display All Appointment");
            System.out.println("[7] Display Appointment");
            System.out.println("[0] Quit");

// Accept user input and perform corresponding operation
            choice = scanner.next().charAt(0);

            switch(choice){
                case '1': addDoctor(doctorList); break;
                case '2': displayDoctors(doctorList); break;
                case '3': addPatient(patientList); break;
                case '4': displayPatients(patientList); break;
                case '5': createAppointment(appList, patientList, doctorList); break;
                case '6': displayAllApps(appList); break;
                case '7': displayApp(appList); break;
                case '0': break;
                default: System.out.println("pick option from menu only");
            }

        }while(choice !='0');

    }
//Displays the appointment details for a given patient.
    private static void displayApp(ArrayList<Appointment> appList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Full Name");
        String name = scanner.nextLine();
        System.out.println("Enter date of birth");
        String dob = scanner.nextLine();

        // Search for appointments matching the given patient details and display them
        for (Appointment app : appList){
            if(app.getPatient().getName().equals(name) && app.getPatient().getDob().equals(dob)){
                System.out.println(app.toString());
            }
        }
    }
    // This method creates three files: "doctors.txt", "patients.txt", and "appointments.txt" using File handling in Java
    //private static void createFiles()
    private static void createFiles()
    {
        try {
            // Create a new file object with the name "doctors.txt"
            File myObj = new File("doctors.txt");
            // Try to create a new file. If it doesn't exist, create it and print a message. If it does exist, print a message saying so.
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("Doctor file already exists.");
            }
        } catch (IOException e) {
            // If an error occurs while creating the file, print an error message and stack trace.
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // create a file object for patients.txt
        try {
            File myObj = new File("patients.txt");
            // create the file if it does not exist and print a message
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("Patients file already exists.");
            }
        } catch (IOException e) {
            // if there is an error, print a message and print the stack trace
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            // create a file object for appointments.txt
            File myObj = new File("appointments.txt");
            // create the file if it does not exist and print a message
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("Appointment file already exists.");
            }
            // if there is an error creating or accessing the file, catch the IOException
        } catch (IOException e) {
            // print an error message to the console to help diagnose the issue
            System.out.println("An error occurred.");
            // print the stack trace to provide more detailed information about the error
            e.printStackTrace();
        }

    }
    // This method takes an ArrayList of Appointment objects and prints out the toString representation of each one.
    private static void displayAllApps(ArrayList<Appointment> appList)
    {
        for (Appointment app : appList){
            System.out.println(app.toString());
        }
    }
    // This method creates a new appointment object and adds it to the given ArrayLists of Appointment, Patient, and Doctor objects.
    private static void createAppointment(ArrayList<Appointment> appList, ArrayList<Patient> pList, ArrayList<Doctor> dList)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Full Name");
        String name = scanner.nextLine();

        System.out.println("Enter date of birth");
        String dob = scanner.nextLine();
        Patient patient = null;


        do{
            patient = searchPatient(name, dob,pList);
            if (patient==null) {
                System.out.println("patient not found, please try again");
                System.out.println("Enter Full Name");
                name = scanner.nextLine();

                System.out.println("Enter date of birth");
                dob = scanner.nextLine();
            }

        }while(patient==null);

        // Print out the toString representation of the Patient object that was found.
        System.out.println(patient.toString());

        System.out.println("Enter date of appointment");
        String date = scanner.nextLine();

        System.out.println("Enter Doctor requested");
        String doctor = scanner.nextLine();

        Doctor doc = null;

        do {
            doc = searchDoctor(doctor, dList);
            if(doc==null){
                System.out.println("Doctor not found, try again");
                doctor = scanner.nextLine();
            }
        }while(doc==null);
        // Print out the toString representation of the Doctor object that was found.
        System.out.println(doc);

        System.out.println("Enter time requested");
        String time = scanner.nextLine();
        // Parse the user's input as a LocalTime object.
        LocalTime lt = LocalTime.parse(time);
        System.out.println(lt);

        System.out.println("Enter description");
        String description = scanner.nextLine();
        // generate an unique ID using UUID
        String id = UUID.randomUUID().toString();
        // create a new Appointment object with the given values
        Appointment app = new Appointment(id, date, patient, doc, description, lt);
        appList.add(app);

        try {
            // Create a FileWriter object for "appointments.txt" file with append mode enabled
            FileWriter myWriter = new FileWriter("appointments.txt", true);
            // Create a BufferedWriter object for the FileWriter object
            BufferedWriter  bw = new BufferedWriter(myWriter);
            // Write the appointment information to the file separated by "&" characters and add a new line
            bw.write(id + "&" + date + "&" + name + "&" + dob + "&" + doctor + "&" + time + "&" + description);
            bw.newLine();
            bw.close();
            // Close the BufferedWriter object and print success message to console
            System.out.println("Successfully wrote to the file.");
            // Catch any IOException that occurs and print error message and stack trace to console
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    // Use of a lambda expression to filter the doctor ArrayList based on the name entered by the user.
    static Doctor searchDoctor(String doctor, ArrayList<Doctor> dList)
    {
        Doctor doc = dList.stream().filter(d -> doctor.equals(d.getName()))
                .findAny()
                .orElse(null);

        return doc;
    }
    // Use of a lambda expression to filter the patient ArrayList based on the name and date of birth entered by the user.
    static Patient searchPatient(String name, String dob, ArrayList<Patient> pList)
    {
        Patient patient = pList.stream().filter(p -> name.equals(p.getName()))
                .filter(p -> dob.equals(p.getDob()))
                .findAny()
                .orElse(null);

        return patient;
    }
    // This method takes in three ArrayLists: dlist for doctors, plist for patients, and appList for appointments
    static void initialiseLists(ArrayList<Doctor> dlist, ArrayList<Patient> plist, ArrayList<Appointment> appList)
    {
        try (FileReader docFile = new FileReader("doctors.txt")) {
            // Create a BufferedReader object for the FileReader object to read from "doctors.txt" file
            BufferedReader docStream = new BufferedReader(docFile);
            // Read the first line of the file
            String tempDoc = docStream.readLine();
            // Loop until the end of the file is reached
            while(tempDoc!=null){
                // Split the line by spaces and store in a String array called "result"
                String[] result = tempDoc.split(" ");
                // Initialise variables for doctor first name, last name, specialization, email, phone number, and ID
                String fName = "", lName = "", spec = "", email="", no="", id="";
                // Loop through each element in the "result" array and store the values in the corresponding variables
                for(int i=0; i<result.length; i++) {
                    fName = result[0];
                    lName = result[1];
                    spec = result[2];
                    email = result[3];
                    no = result[4];
                    id = result[5];
                }
                // Add a new Doctor object to the dlist ArrayList using the variables initialised above
                dlist.add(new Doctor(fName+ " " + lName, spec, email, no, id));
                // Read the next line of the file
                tempDoc = docStream.readLine();
            }
            // Close the BufferedReader object
            docStream.close();
        }catch(IOException e){
            System.out.println("unable to read file");
        }

        try (FileReader docFile = new FileReader("patients.txt")) {
            // Create a BufferedReader object for the FileReader object to read
            BufferedReader patientStream = new BufferedReader(docFile);
            // Read the first line of the file
            String tempPatient = patientStream.readLine();
            // Loop until the end of the file is reached
            while(tempPatient!=null){
                // Split the line by "&" characters and store in a String array called "result"
                String[] result = tempPatient.split("&");
                // Initialise variables for patient name, date of birth, email, phone number, and ID
                String name = "", dob = "", email="", no="", id="";
                // loop through each element in the"result" array and store the values in the corresponding var
                for(int i=0; i<result.length; i++) {
                    name = result[0];
                    dob = result[1];
                    email = result[2];
                    no = result[3];
                    id = result[4];
                }
                // Add a new Patient object to the dlist ArrayList using the variables initialised above
                plist.add(new Patient(name, email, no, id, dob));
                // Read the next line of the file
                tempPatient = patientStream.readLine();
            }

            // Close the BufferedReader object
            patientStream.close();
        }catch(IOException e){
            // Catch any IOException that occurs and print error message to console
            System.out.println("unable to read file");
        }

        try (FileReader docFile = new FileReader("appointments.txt")) {
            // Create a BufferedReader object for the FileReader object to read from "appointments.txt" file
            BufferedReader appStream = new BufferedReader(docFile);
            // Read the first line of the file
            String tempApp = appStream.readLine();
            // Loop until the end of the file is reached
            while(tempApp!=null){
                // Split the line by "&" characters and store in a String array called "result"
                String[] result = tempApp.split("&");
                // Initialise variables for patient name, date of birth, email, phone number, and ID
                String id = "", date = "", time = "", patient="", doctor="", description="", dob="";
                // Loop through each element in the "result" array and store the values in the corresponding variables
                for(int i=0; i<result.length; i++) {
                    id = result[0];
                    date = result[1];
                    patient = result[2];
                    dob = result[3];
                    doctor = result[4];
                    time = result[5];
                    description = result[6];
                }
                Patient pat = null;
                // loop through the list of patients to find the one with the matching name and date of birth
                for(Patient p: plist){
                    if(p.getName().equals(patient) && p.getDob().equals(dob)){
                        pat = p;
                        // exit the loop when the patient is found
                        break;
                    }
                }

                Doctor doc = null;
                // loop through the list of doctors to find the one with the matching name
                for(Doctor d: dlist){
                    if(d.getName().equals(doctor)){
                        doc = d;
                        break;
                    }
                }
// add a new appointment to the list of appointments with the patient and doctor found above
            appList.add(new Appointment(id, date, pat, doc, description, LocalTime.parse(time)));
                // read the next line of appointments from the file
                tempApp = appStream.readLine();
            }
// close the appointment file
            appStream.close();
        }catch(IOException e){
            System.out.println("unable to read file");
        }


    }

    static void displayDoctors(ArrayList<Doctor> dlist)
    {
        // display the list of doctors
        for (Doctor doctor : dlist){
            System.out.println(doctor.toString());
        }
    }

    static void addDoctor(ArrayList<Doctor> dlist)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter doctor's name");
        String name = scanner.nextLine();

        System.out.println("Enter doctor's speciality");
        String speciality = scanner.nextLine();

        System.out.println("Enter doctor's email");
        String email = scanner.nextLine();
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        while(!email.matches(emailRegex)){
            System.out.println("Please enter a valid email address");
            email = scanner.nextLine();
        }


        System.out.println("Enter doctor's number");
        String contactNo = scanner.nextLine();

        String numRegex = "\\d{100}";

        while(!contactNo.matches(numRegex)){
            System.out.println("Please enter a valid 11 digit phone number");
            contactNo = scanner.nextLine();
        }

        String id = UUID.randomUUID().toString();

        try {
            // open "doctors.txt" file in append mode, write the doctor's information to it, and close it
            FileWriter myWriter = new FileWriter("doctors.txt", true);
            BufferedWriter  bw = new BufferedWriter(myWriter);
            bw.write(name + " " + speciality + " " + email + " " + contactNo + " " + id);
            bw.newLine();
            bw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            // if an error occurs while writing to the file, print an error message and stack trace
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        dlist.add(new Doctor(name, speciality, email, contactNo, id));
    }


    // display information about all patients in an ArrayList of Patient objects
    static void displayPatients(ArrayList<Patient> plist)
    {
        for (Patient patient : plist){
            System.out.println(patient.toString());
        }
    }
    // add a new Patient object to an ArrayList of Patient objects
    static void addPatient(ArrayList<Patient> plist)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient's name");
        String name = scanner.nextLine();
// Input validation for date of birth
        System.out.println("Enter patient's date of birth (dd/mm/yyyy)");
        String dob = scanner.nextLine();
        String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        while(!dob.matches(regex)){
            System.out.println("Please enter the date in the correct format");
            System.out.println("Enter patient's date of birth (dd/mm/yyyy)");
            dob = scanner.nextLine();
        }

// Input validation for email address
        System.out.println("Enter patient's email");
        String email = scanner.nextLine();
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        while(!email.matches(emailRegex)){
            System.out.println("Please enter a valid email address");
            email = scanner.nextLine();
        }
// Input validation for phone number
        System.out.println("Enter patient's contact number");
        String contactNo = scanner.nextLine();
        String numRegex = "\\d{11}";

        while(!contactNo.matches(numRegex)){
            System.out.println("Please enter a valid 11 digit phone number");
            contactNo = scanner.nextLine();
        }
// Generate a unique ID for the patient
        String id = UUID.randomUUID().toString();

        try {
            // Write patient details to a file
            FileWriter myWriter = new FileWriter("patients.txt", true);
            BufferedWriter  bw = new BufferedWriter(myWriter);
            bw.write(name + "&" + dob + "&" + email + "&" + contactNo + "&" + id);
            bw.newLine();
            bw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            // Handle exceptions while writing to the file
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
// Create a new Patient object with the validated input and add to list

        plist.add(new Patient(name, email, contactNo, id, dob));
    }

}
