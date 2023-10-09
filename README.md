# GP_Case_Study The system allows managing doctors, patients, and appointments at a doctor's office. It uses Java and JavaFX for the graphical user interface.
Here is a description of the JavaFX code to implement a doctor's appointment system:

The JavaFX application creates a graphical user interface (GUI) for the doctor's appointment system. It uses JavaFX components like Stage, Scene, Buttons, TextFields, and TableViews to build the interface. 

The main class extends Application and overrides the start() method to setup the GUI. It first creates a BorderPane as the root layout container. A title label is added to the top and centered. The bottom section contains a HBox layout to hold the menu buttons horizontally. 

The menu buttons include:

- Add Doctor - Opens a dialog to enter doctor details 
- Display Doctors - Shows a table with doctor data
- Add Patient - Opens a dialog to enter patient details
- Display Patients - Shows a table with patient data  
- Create Appointment - Opens a dialog to enter appointment details
- Display Appointments - Shows a table with appointment data
- Quit - Closes the application

The dialogs contain GridPanes with Labels and TextFields to enter data. The data is collected and Java objects like Doctor, Patient and Appointment are created and stored in ArrayLists. 

The TableViews are linked to these lists to display the data. The columns are defined by mapping the object properties to TableColumn cell value factories.

Event handlers are added to the buttons to show the dialogs and update the data models.

The application loads initial data from text files on startup using File I/O. Additional data entered by the user is appended to these files.

This creates a full-featured GUI application for the core functionality of a doctor's office system using JavaFX for the front-end and object-oriented design for the back-end. The MVC pattern separates the data models, business logic and visual presentation.
