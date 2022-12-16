package com.example.classes;

import java.util.ArrayList;
import java.util.Random;

public class Journal {
    public ArrayList<Student> students = new ArrayList<>();
    private String homeWork = "Домашнее задание";
    private int hWCount = 0;
    private final int classNumber;
    private final String classLetter;
    public Journal(int classNumber, String classLetter){
        this.classNumber = classNumber;
        this.classLetter = classLetter;
        for (int i = 0; i < 10; i++){
            Random randName = new Random();
            Random randSurname = new Random();
            students.add(new Student(Container.names.get(randName.nextInt(Container.names.size())),
                    Container.surNames.get(randSurname.nextInt(Container.surNames.size())), this));
        }
        System.out.println(students);
    }

    public void addHomeWork(String newHw){
        hWCount++;
        this.homeWork += "\n" + hWCount + ". " + newHw;
    }
    public String getHomeWork() {
        return homeWork;
    }

    @Override
    public String toString(){
        return this.classNumber + this.classLetter;
    }
}
