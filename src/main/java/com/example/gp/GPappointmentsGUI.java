package com.example.gp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

 class GPappointmentsGUI extends Application {

     @Override
     public void start(Stage primaryStage) {
         // Create a text node to display in the window
         Text helloWorld = new Text("Hello, JavaFX!");

         // Create a layout container for the buttons
         HBox buttonBox = new HBox();
         Button button1 = new Button("Button 1");
         Button button2 = new Button("Button 2");
         buttonBox.getChildren().addAll(button1, button2);

         // Create a layout container for the text and buttons
         StackPane root = new StackPane();
         root.getChildren().addAll(helloWorld, buttonBox);

         // Create a scene with the layout container
         Scene scene = new Scene(root, 300, 250);

         // Set the scene on the primary stage
         primaryStage.setScene(scene);

         // Set the title of the window
         primaryStage.setTitle("My JavaFX App");

         // Show the window
         primaryStage.show();
     }

     public static void main(String[] args) {
         launch(args);
     }
 }