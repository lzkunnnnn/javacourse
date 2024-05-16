package com.experiments.experiment04.resource;

import com.experiments.experiment04.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static final List<Student> STUDENTS = create();
    private static List<Student> create() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2022212854, Student.Sex.MALE, "李梓坤", 2022));
        students.add(new Student(2022212855, Student.Sex.MALE, "张正烨", 2022));
        students.add(new Student(2022212856, Student.Sex.FEMALE, "马赫", 2023));
        students.add(new Student(2022212863, Student.Sex.MALE, "张扬", 2021));
        students.add(new Student(2022212878, Student.Sex.FEMALE, "吕惠玲", 2022));
        return students;
    }

    //listStudents() 方法是一个公共静态方法，用于获取学生信息列表。
    //当其他类需要访问学生信息列表时，可以直接调用该方法。
    //此方法简单地返回 STUDENTS 常量，提供了对学生信息列表的访问接口。
    public static List<Student> listStudents() {
        return STUDENTS;
    }

    public static List<Student> getStudents() {
        return STUDENTS;
    }
}
