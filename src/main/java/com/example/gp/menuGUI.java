package com.example.gp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;





public class menuGUI extends Application {


    private final ComboBox<Patient> pCombobox = new ComboBox<>();
    private final ListView<Patient> listView = new ListView<>();



    public static void main(String[] args) {
        launch(args);
    }

    public ComboBox<Patient> getPComboBox() {
        return this.pCombobox;

    }

    @Override
    public void start(Stage primaryStage)  {

        final int WIDTH = 800;
        final int HEIGHT = 500;

        // set the width of the stage
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        // Create the title label
        Label titleLabel = new Label("Doctor Appointment System");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.WHITE);

        // Create the root BorderPane and set its properties
        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));

        // Add the title label to the top of the BorderPane and center it
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        BorderPane.setMargin(titleLabel, new Insets(20));
        root.setTop(titleLabel);

        // Add the title label to the top of the BorderPane and center it
        root.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);

        // Set the margin of the title label
        BorderPane.setMargin(titleLabel, new Insets(20));

        // Create the HBox for the buttons and set its properties
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));
        root.setCenter(buttonBox);


        // Create the scene and set it to the primaryStage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.BLUE);
        primaryStage.setScene(scene);
        primaryStage.show();

        // set background color of VBox
        root.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));



        //create the table view for displaying patient data

        TableView<Patient> patientTableView = new TableView<>();
        patientTableView.setStyle("-fx-background-color: white;");
        ArrayList<Patient> patientList = new ArrayList<>();
        Patient[] patientArray = patientList.toArray((Patient[]) Array.newInstance(Patient.class, patientList.size()));

        TableView<Doctor> doctorTableView = new TableView<>();
        ArrayList<Doctor> doctorList = new ArrayList<>();
        patientTableView.setStyle("-fx-background-color: white;");

        TableView<Patient> patientTableView1 = new TableView<>();

        TableView<Appointment> appointmentTableView = new TableView<>();
        ArrayList<Appointment> appList = new ArrayList<>();
        patientTableView1.setStyle("-fx-background-color: white;");

        Button button = new Button("My Button");
        button.setRotate(90);


        // create buttons for the menu
        Button addDoctorBtn = new Button("Add Doctor");
        addDoctorBtn.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        Button displayDoctorsBtn = new Button("Display Doctors");
        displayDoctorsBtn.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField doctorField = new TextField();
        Button addPatientBtn = new Button("Add Patient");
        addPatientBtn.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        Button displayPatientsBtn = new Button("Display Patients");
        displayPatientsBtn.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField patientField = new TextField();
        Button createAppointmentBtn = new Button("Create Appointment");
        createAppointmentBtn.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        Button displayAllAppointmentBtn = new Button("Display All Appointment");
        displayAllAppointmentBtn.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");

        Button displayAppointmentBtn = new Button("Display Appointment");
        displayAppointmentBtn.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");
        TextField appointmentField = new TextField();
        Button quitBtn = new Button("Quit");
        quitBtn.setStyle("-fx-background-color: #2196f3; -fx-text-fill: white; -fx-font-weight: bold;");
        TextArea displayArea = new TextArea();


        // create the grid pane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Color myColor = Color.BLUE;
        titleLabel.setTextFill(myColor);

        // add the components to the grid pane
        gridPane.add(titleLabel, 0,0,3,1);
        gridPane.add(addDoctorBtn, 0,1);
        gridPane.add(displayDoctorsBtn, 1,1);
        gridPane.add(displayPatientsBtn, 1,2);
        gridPane.add(createAppointmentBtn, 0,3);
        gridPane.add(displayAllAppointmentBtn,1,3 );
        gridPane.add(displayAppointmentBtn, 2, 3);
        gridPane.add(quitBtn, 0,4);

        ObservableList<Patient> patientData = FXCollections.observableArrayList(patientList);
        ObservableList<Doctor> doctorData = FXCollections.observableArrayList(doctorList);
        ObservableList<Appointment> appointmentData = FXCollections.observableArrayList(appList);



        // create the menu layout
        VBox menuLayout = new VBox(10);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setPadding(new Insets(20));
        menuLayout.getChildren().addAll( addDoctorBtn, displayDoctorsBtn, addPatientBtn, displayPatientsBtn, createAppointmentBtn, displayAllAppointmentBtn, displayAppointmentBtn, quitBtn, patientTableView);


       // menuGUI myGUI = new menuGUI();
        //myComboBox = myGUI.getPComboBox();
        // create the scene and show the stage
        Scene menuScene = new Scene(menuLayout, 400, 400);
        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Doctor Surgery System");
        primaryStage.show();

        initialiseLists(doctorList, patientList, appList);
        System.out.println(patientList);
        initialize(patientList,patientTableView );

  //This code puts the action for the "adDoctorBtn" button. Once the button is clicked, it displays a new dialog to add a new doctor.
        addDoctorBtn.setOnAction(e -> {  // set button actions
            // create a new dialog to add a new doctor
            Dialog<String[]> dialog = new Dialog<>();
            dialog.setTitle("Add New Doctor");
            dialog.setHeaderText("Enter doctor details");

            // create a GridPane to hold the form
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            // create TextFields for each input field
            TextField nameField = new TextField();
            nameField.setPromptText("Name");
            TextField specialtyField = new TextField();
            specialtyField.setPromptText("Specialty");
            TextField phoneField = new TextField();
            phoneField.setPromptText("Phone number");
            TextField emailField = new TextField();
            emailField.setPromptText("Email");

            // add the TextFields to the GridPane
            grid.add(new Label("Name:"), 0, 0);
            grid.add(nameField, 1, 0);
            grid.add(new Label("Specialty:"), 0, 1);
            grid.add(specialtyField, 1, 1);
            grid.add(new Label("Phone number:"), 0, 2);
            grid.add(phoneField, 1, 2);
            grid.add(new Label("Email:"), 0, 3);
            grid.add(emailField, 1, 3);

            // add the GridPane to the dialog's content pane
            dialog.getDialogPane().setContent(grid);


            // add buttons to the dialog
            ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // set the result converter to convert the input fields to a String array
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == addButton) {
                    return new String[] { nameField.getText(), specialtyField.getText(), phoneField.getText(), emailField.getText() };
                }
                return null;
            });

            // add the close button
            ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(closeButton);
            // show the dialog and wait for the user to use it
            dialog.showAndWait();

        });
        displayDoctorsBtn.setOnAction(e -> {
            // code for displaying all doctors
            Dialog<String[]> dialog = new Dialog<>();
            dialog.setTitle("Display Doctors");
            dialog.setHeaderText("Show doctor details");

            // create the table view to display doctors
            TableColumn<Doctor, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            TableColumn<Doctor, String> specialtyColumn = new TableColumn<>("Specialty");
            specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));
            TableColumn<Doctor, Double> contactNumberColumn = new TableColumn<>("Contact Number");
            contactNumberColumn.setCellValueFactory(new PropertyValueFactory<>("Contact Number"));
            TableColumn<Doctor, String> empIDColumn = new TableColumn<>("Employer ID");
            empIDColumn.setCellValueFactory(new PropertyValueFactory<>("Employer ID"));
            doctorTableView.getColumns().addAll(nameColumn, specialtyColumn, contactNumberColumn, empIDColumn);
            doctorTableView.setItems(doctorData);

            // add the table view to the dialog
            dialog.getDialogPane().setContent(doctorTableView);

            // add the close button
            ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(closeButton);

            dialog.showAndWait();


        });
        addPatientBtn.setOnAction(e -> {
            // code for adding a patient
            Dialog<String[]> dialog = new Dialog<>();
            dialog.setTitle("Add New Patient");
            dialog.setHeaderText("Enter patient details");


            // create a GridPane to hold the form
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));


            // create TextFields for each input field
            TextField nameField = new TextField();
            nameField.setPromptText("Name");
            TextField emailField = new TextField();
            emailField.setPromptText("Email");
            TextField contactNoField = new TextField();
            contactNoField.setPromptText("ContactNo");
            TextField patientIDField = new TextField();
            patientIDField.setPromptText("PatientID");
            TextField dobField = new TextField();
            dobField.setPromptText("DOB");

            // add the TextFields to the GridPane
            grid.add(new Label("Name:"), 0, 0);
            grid.add(nameField, 1, 0);
            grid.add(new Label("Email:"), 0, 1);
            grid.add(emailField, 1, 1);
            grid.add(new Label("ContactNo:"), 0, 2);
            grid.add(contactNoField, 1, 2);
            grid.add(new Label("PatientID:"), 0, 3);
            grid.add(patientIDField, 1, 3);
            grid.add(new Label("DOB:"), 0, 4);
            grid.add(dobField, 1, 4);

            // add the GridPane to the dialog's content pane
            dialog.getDialogPane().setContent(grid);


            // add buttons to the dialog
            ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // set the result converter to convert the input fields to a String array
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == addButton) {
                    return new String[] { nameField.getText(), emailField.getText(), contactNoField.getText(), patientIDField.getText(),dobField.getText() };
                }
                return null;
            });

            // add the close button
            ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(closeButton);

            dialog.showAndWait();

        });
        displayPatientsBtn.setOnAction(e -> {
            // code for displaying all patients
            Dialog<String[]> dialog = new Dialog<>();
            dialog.setTitle("Display Patient");
            dialog.setHeaderText("Display Patient details");

            // create the table view to display doctors
            TableColumn<Doctor, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            TableColumn<Doctor, String> specialtyColumn = new TableColumn<>("Email");
            specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));
            TableColumn<Doctor, Double> contactNumberColumn = new TableColumn<>("Contact Number");
            contactNumberColumn.setCellValueFactory(new PropertyValueFactory<>("Contact Number"));
            TableColumn<Doctor, String> empIDColumn = new TableColumn<>("Patient ID");
            empIDColumn.setCellValueFactory(new PropertyValueFactory<>("Employer ID"));
            TableColumn<Doctor, String> dodColumn = new TableColumn<>("DOB");
            dodColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));
            doctorTableView.getColumns().addAll(nameColumn, specialtyColumn, contactNumberColumn, empIDColumn, dodColumn);
            doctorTableView.setItems(doctorData);

            // add the table view to the dialog
            dialog.getDialogPane().setContent(doctorTableView);

            // add the close button
            ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(closeButton);

            dialog.showAndWait();


        });
        createAppointmentBtn.setOnAction(e -> {
            // code for creating an appointment
            Dialog<String[]> dialog = new Dialog<>();
            dialog.setTitle("Create New Appointment");
            dialog.setHeaderText("Enter Appointment details");

            // create a GridPane to hold the form
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            // create TextFields for each input field
            TextField dateField = new TextField();
            dateField.setPromptText("Date");
            TextField timeField = new TextField();
            timeField.setPromptText("Time");
            TextField patientField1 = new TextField();
            patientField1.setPromptText("Patient");
            TextField doctorField1 = new TextField();
            doctorField1.setPromptText("Doctor");
            TextField descriptionField = new TextField();
            descriptionField.setPromptText("Description");

            // add the TextFields to the GridPane
            grid.add(new Label("Date:"), 0, 0);
            grid.add(dateField, 1, 0);
            grid.add(new Label(" Time:"), 0, 1);
            grid.add(timeField, 1, 1);
            grid.add(new Label("Patient:"), 0, 2);
            grid.add(patientField1, 1, 2);
            grid.add(new Label("doctor:"), 0, 3);
            grid.add(doctorField1, 1, 3);
            grid.add(new Label("Description:"), 0, 4);
            grid.add(descriptionField, 1, 4);

            // add the GridPane to the dialog's content pane
            dialog.getDialogPane().setContent(grid);


            // add buttons to the dialog
            ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // set the result converter to convert the input fields to a String array
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == addButton) {
                    return new String[] { dateField.getText(), timeField.getText(), patientField.getText(), patientField.getText(),doctorField.getText(), descriptionField.getText() };
                }
                return null;
            });

            // add the close button
            ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(closeButton);

            dialog.showAndWait();

        });
        displayAllAppointmentBtn.setOnAction(e -> {
            // code for displaying all appointments
            Dialog<String[]> dialog = new Dialog<>();
            dialog.setTitle("Display all Appointment");


            TextField nameField = new TextField();
            nameField.setPromptText("Name");
            TextField emailField = new TextField();
            emailField.setPromptText("Email");
            TextField contactNoField = new TextField();
            contactNoField.setPromptText("ContactNo");
            TextField patientIDField = new TextField();
            patientIDField.setPromptText("PatientID");
            TextField dobField = new TextField();
            dobField.setPromptText("DOB");


            // create the table view to display doctors
            TableColumn<Appointment, String> dateColumn = new TableColumn<>("Date");
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            TableColumn<Appointment, String> timeColumn = new TableColumn<>("Time");
            timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
            TableColumn<Appointment, Double> patientNoColumn = new TableColumn<>("Patient");
            patientNoColumn.setCellValueFactory(new PropertyValueFactory<>("PatientName"));
            TableColumn<Appointment, Double> doctorColumn = new TableColumn<>("Doctor");
            doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
            TableColumn<Appointment, Double> descriptionColumn = new TableColumn<>("Description");
            descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
            appointmentTableView.getColumns().addAll(dateColumn, timeColumn, patientNoColumn, doctorColumn, descriptionColumn);
            appointmentTableView.setItems(appointmentData);

            // add the table view to the dialog
            dialog.getDialogPane().setContent(appointmentTableView);

            // add the close button
            ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(closeButton);

            dialog.showAndWait();


        });
        displayAppointmentBtn.setOnAction(e -> {
            // code for displaying a single appointment
            Dialog<String[]> dialog = new Dialog<>();
            dialog.setTitle("Display Appointment");
            dialog.setHeaderText("Show Appointment details");

            // create the table view to display doctors
            TableColumn<Doctor, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            TableColumn<Doctor, String> specialtyColumn = new TableColumn<>("Specialty");
            specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));
            TableColumn<Doctor, Double> contactNumberColumn = new TableColumn<>("Contact Number");
            contactNumberColumn.setCellValueFactory(new PropertyValueFactory<>("Contact Number"));
            TableColumn<Doctor, String> empIDColumn = new TableColumn<>("Employer ID");
            empIDColumn.setCellValueFactory(new PropertyValueFactory<>("Employer ID"));
            doctorTableView.getColumns().addAll(nameColumn, specialtyColumn, contactNumberColumn, empIDColumn);
            doctorTableView.setItems(doctorData);

            // add the table view to the dialog
            dialog.getDialogPane().setContent(doctorTableView);



            TextField dateField = new TextField();
            dateField.setPromptText("Date");
            TextField timeField = new TextField();
            timeField.setPromptText("Time");
            TextField patientField1 = new TextField();
            patientField.setPromptText("Patient");
            TextField doctorField1 = new TextField();
            doctorField.setPromptText("doctor");
            TextField descriptionField = new TextField();
            descriptionField.setPromptText("Description");

            // create the table view to display doctors
            TableColumn<Patient, String> dateColumn = new TableColumn<>("Date");
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
            TableColumn<Patient, String> timeColumn = new TableColumn<>("Time");
            timeColumn.setCellValueFactory(new PropertyValueFactory<>("Time"));
            TableColumn<Patient, String> patientIDColumn = new TableColumn<>("Patient");
            patientIDColumn.setCellValueFactory(new PropertyValueFactory<>("Patient"));
            TableColumn<Patient, String> doctorColumn = new TableColumn<>("Doctor");
            doctorColumn.setCellValueFactory(new PropertyValueFactory<>("Doctor"));
            TableColumn<Patient, String> descriptionColumn = new TableColumn<>("Description");
            descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
            appointmentTableView.getColumns().addAll();
            appointmentTableView.setItems(appointmentData);

            // add the table view to the dialog
            dialog.getDialogPane().setContent(appointmentTableView);

            // add the close button
            ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(closeButton);
            dialog.showAndWait();


        });
        quitBtn.setOnAction(e -> {
            primaryStage.close();
        });

    }



    void initialize(ArrayList<Patient> pList, TableView<Patient> patientTableView) {

        // set the column for displaying the patient
        TableColumn<Patient, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Patient, String> emailCol = new TableColumn<>("email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Patient, String> conColumn = new TableColumn<>("contact");
        conColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        TableColumn<Patient, String> idCol = new TableColumn<>("id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Patient, String> dobCol = new TableColumn<>("dob");
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));

        patientTableView.getColumns().add(nameColumn);
        patientTableView.getColumns().add(emailCol);
        patientTableView.getColumns().add(conColumn);
        patientTableView.getColumns().add(idCol);
        patientTableView.getColumns().add(dobCol);

        patientTableView.setItems(FXCollections.observableArrayList(pList));

        ObservableList<Patient> patientData = FXCollections.observableArrayList(pList);
        listView.setItems(patientData);





        //listView.setItems(patientData);
        conColumn.setCellFactory(column -> {
            TableCell<Patient, String> cell = new TableCell<>() {
                private final NumberFormat nf = NumberFormat.getCurrencyInstance();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(nf.format(Double.parseDouble(item)));
                    }
                }
            };
            return cell;
        });
        patientTableView.getColumns().add(conColumn);
        patientTableView.setItems(FXCollections.observableArrayList());
    }

    List<Patient> patientList = new ArrayList<>();

    private void initialiseLists(ArrayList<Doctor> dlist, ArrayList<Patient> plist, ArrayList<Appointment> appList)
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


}
