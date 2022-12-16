package com.example.classjournal;

import com.example.classes.Container;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class StudentPageController {
    public TextField fieldName;
    public TextField fieldClass;
    public ComboBox<String> comboSubjects;
    public Button buttonApprove;
    public TextArea fieldHw;
    public TextField fieldMarks;
    public Button buttonBack;
    public Label textError;
    private void changeWindow(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("register_page.fxml"));
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

    public void initialize(){
        ObservableList<String> subs = FXCollections.observableList(Container.subjects);
        comboSubjects.setItems(subs);
        fieldName.setText(Container.currentStudent.getName());
        fieldClass.setText(String.valueOf(Container.currentStudent.ownClass));
    }
    public void buttonBackClick(){
        changeWindow();
    }
    public void buttonApproveClick(){
        String subject = comboSubjects.getValue();
        if (subject != null) {
            textError.setText("");
            fieldHw.setText(Container.currentClass.students.get(0).getSubjectBuyName(subject).getHomeWork());
            fieldMarks.setText(String.valueOf(Container.currentStudent.getSubjectBuyName(subject).marks));
            if (Container.currentStudent.getSubjectBuyName(subject).getAverage() > 4.5f) {
                fieldMarks.setStyle("-fx-text-fill: green;");
            } else if (Container.currentStudent.getSubjectBuyName(subject).getAverage() < 2.5f) {
                fieldMarks.setStyle("-fx-text-fill: red;");
            } else {
                fieldMarks.setStyle("-fx-text-fill: orange;");
            }
        } else {
            textError.setText("Выберите предмет!");
        }
    }
}
