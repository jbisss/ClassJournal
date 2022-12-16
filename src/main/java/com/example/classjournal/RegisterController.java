package com.example.classjournal;

import com.example.classes.Container;
import com.example.classes.Journal;
import com.example.classes.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    public TextField fieldLogin;
    public TextField fieldPassword;
    public Button buttonApprove;
    public Label textError;
    private void changeWindow(String window){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(window));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Window");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) buttonApprove.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void approveButtonClick(){
        if (Container.teacher.getLogin().equals(fieldLogin.getText())
                && Container.teacher.getPassword().equals(fieldPassword.getText())) {
            changeWindow("teacher_page.fxml");
        } else {
            for (Journal journal : Container.classes) {
                for (Student student : journal.students) {
                    if ((student.getName() + student.getId()).equals(fieldLogin.getText())
                            && student.getSurName().equals(fieldPassword.getText())){
                        Container.currentStudent = student;
                        changeWindow("student_page.fxml");
                    }
                }
            }
            textError.setText("Нет такого учителя или ученика!");
        }
    }

    public void initialize(){
        Container.loadClass();
    }
}