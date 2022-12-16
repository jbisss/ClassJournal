package com.example.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Container {
    public static void loadClass(){}
    public static ArrayList<String> names = new ArrayList<>(Arrays.asList("Руслан", "Георгий", "Василий", "Лионель",
            "Олег", "Евгений", "Александр", "Альберт", "Владимир", "Ольга", "Софья", "Камилла", "Мария", "Виктория",
            "Алина", "Евгения", "Наталья", "Ирина"));
    public static ArrayList<String> surNames = new ArrayList<>(Arrays.asList("Долгих", "Черных", "Кручёных", "Гретри",
            "Бойко", "Блок", "Топчих", "Месси", "Акутагава", "Агеенко", "Зализняк", "Марадона", "Скалозуб",
            "Шевченко", "Дрогба", "Камень"));
    public static ArrayList<String> subjects = new ArrayList<>(Arrays.asList("Математика", "Русский язык",
            "Английский язык", "Окружающий мир", "Труд", "Чтение"));
    public static ArrayList<Journal> classes = new ArrayList<>();
    public static Teacher teacher;
    public static Student currentStudent;
    public static Journal currentClass;
    static {
        classes.add(new Journal(1, "А"));
        classes.add(new Journal(2, "Б"));
        classes.add(new Journal(3, "В"));
        teacher = new Teacher("Марина Ивановна", "marina", "passwordovna");
        System.out.println("Done");
    }
}
