package com.example.classjournal;

import com.example.classes.Container;
import com.example.classes.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeacherPageController {
    public TextField fieldNumberClass;
    public TextField fieldLetterClass;
    public Button buttonApprove;
    public Label textError;
    public TextField fieldChosenClass;
    public VBox vBoxStudent;
    public TextArea fieldHw;
    public TextArea fieldHwToAdd;
    public Button buttonHwAdd;
    public ComboBox<String> comboSubject;
    public TextField fieldMarkToAdd;
    public Label textErrorMark;
    public Button buttonBack;
    public Label textTeacherName;
    public void initialize(){
        textTeacherName.setText(Container.teacher.getName());
        ObservableList<String> subs = FXCollections.observableList(Container.subjects);
        comboSubject.setItems(subs);
    }
    public void buttonHwAddClick(){
        String subject = comboSubject.getValue();
        for (Student student : Container.currentClass.students){
            student.getSubjectBuyName(subject).addHomeWork(fieldHwToAdd.getText());
        }
        fieldHwToAdd.setText("");
        fieldHw.setText(Container.currentClass.students.get(0).getSubjectBuyName(subject).getHomeWork());

    }
    public void buttonApproveClick(){
        textError.setText("");
        int classNumber = 0;
        try {
            classNumber = Integer.parseInt(fieldNumberClass.getText());
        } catch (Exception exception) {
            textError.setText("Ошибка ввода!");
        }
        String classLetter = fieldLetterClass.getText();
        String subject = comboSubject.getValue();
        boolean flagSubject = Container.subjects.contains(subject);
        boolean flagContinue = false;
        if (classNumber == 1 && classLetter.equals("А") && flagSubject){
            Container.currentClass = Container.classes.get(0);
            flagContinue = true;
        } else if (classNumber == 2 && classLetter.equals("Б") && flagSubject){
            Container.currentClass = Container.classes.get(1);
            flagContinue = true;
        } else if (classNumber == 3 && classLetter.equals("В") && flagSubject){
            Container.currentClass = Container.classes.get(2);
            flagContinue = true;
        } else {
            textError.setText("Нет такого класса/предмета!");
        }
        if (flagContinue) {
            vBoxStudent.getChildren().clear();
            fieldChosenClass.setText(String.valueOf(Container.currentClass));
            fieldHw.setText(Container.currentClass.students.get(0).getSubjectBuyName(subject).getHomeWork());
            for (Student student : Container.currentClass.students){
                HBox hBox = new HBox();
                TextField textName = new TextField();
                textName.setEditable(false);
                textName.setPrefWidth(200);
                TextField textMarks = new TextField();
                textMarks.setEditable(false);
                Button buttonMarkAdd = new Button("Добавить оценку");
                buttonMarkAdd.setOnAction(actionEvent -> {
                    textErrorMark.setText("");
                    try{
                        int markToAdd = Integer.parseInt(fieldMarkToAdd.getText());
                        if (markToAdd > 1 && markToAdd < 6){
                            student.getSubjectBuyName(subject).addMark(markToAdd);
                            textMarks.setText(String.valueOf(student.getSubjectBuyName(subject).marks));
                            if (student.getSubjectBuyName(subject).getAverage() > 4.5f) {
                                textMarks.setStyle("-fx-text-fill: green;");
                            } else if (student.getSubjectBuyName(subject).getAverage() < 2.5f) {
                                textMarks.setStyle("-fx-text-fill: red;");
                            } else {
                                textMarks.setStyle("-fx-text-fill: orange;");
                            }
                            fieldMarkToAdd.setText("");
                        } else {
                            textErrorMark.setText("Нет такой оценки!");
                        }
                    } catch (Exception exception) {
                        textErrorMark.setText("Невверный формат ввода!");
                    }
                });
                hBox.getChildren().add(textName);
                hBox.getChildren().add(textMarks);
                hBox.getChildren().add(buttonMarkAdd);
                textName.setText(String.valueOf(student));
                if (student.getSubjectBuyName(subject).getAverage() > 4.7f) {
                    textMarks.setStyle("-fx-text-fill: green;");
                } else if (student.getSubjectBuyName(subject).getAverage() < 2.5f) {
                    textMarks.setStyle("-fx-text-fill: red;");
                } else {
                    textMarks.setStyle("-fx-text-fill: orange;");
                }
                textMarks.setText(String.valueOf(student.getSubjectBuyName(subject).marks));
                vBoxStudent.getChildren().add(hBox);
            }
        }
    }
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
    public void buttonBackClick(){
        changeWindow();
    }
}
