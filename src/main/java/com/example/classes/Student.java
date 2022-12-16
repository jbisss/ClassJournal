package com.example.classes;

import java.util.ArrayList;

public class Student {
    private static int count = 0;
    private final int id;
    private final String name;
    private final String surName;
    public Journal ownClass;
    public ArrayList<Subject> subjects = new ArrayList<>();

    public Student(String name, String surName, Journal ownClass){
        count++;
        id = count;
        this.name = name;
        this.surName = surName;
        this.ownClass = ownClass;
        for (String subject : Container.subjects) {
            subjects.add(new Subject(subject));
        }
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getId() {
        return id;
    }
    public Subject getSubjectBuyName(String subject){
        for (Subject iSubject : subjects) {
            if (iSubject.getName().equals(subject)) {
                return iSubject;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getSurName() + " id: " + this.id;
    }
}
