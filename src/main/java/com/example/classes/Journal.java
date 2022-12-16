package com.example.classes;

import java.util.ArrayList;
import java.util.Random;

public class Journal {
    public ArrayList<Student> students = new ArrayList<>();

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



    @Override
    public String toString(){
        return this.classNumber + this.classLetter;
    }
}
