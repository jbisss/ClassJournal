package com.example.classes;

import java.util.ArrayList;
import java.util.Random;

public class Subject {
    public ArrayList<Integer> marks = new ArrayList<>();
    private final String name;
    private String homeWork = "Домашнее задание";
    private int hWCount = 0;
    public void addHomeWork(String newHw){
        hWCount++;
        this.homeWork += "\n" + hWCount + ". " + newHw;
    }
    public String getHomeWork() {
        return homeWork;
    }
    private int sum = 0;
    private int count = 0;
    public Subject(String name){
        this.name = name;
        Random randMarksAmount = new Random();
        for(int i = 0; i < randMarksAmount.nextInt(6) + 1; i++) {
            Random randMark = new Random();
            addMark(randMark.nextInt(4) + 2);
        }
    }

    public double getAverage(){
        return (double) this.sum / this.count;
    }
    public void addMark(int mark){
        count++;
        sum += mark;
        marks.add(mark);
    }
    public String getName() {
        return name;
    }
}
