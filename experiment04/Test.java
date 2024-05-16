package com.experiments.experiment04;

import com.experiments.experiment04.entity.Student;
import com.experiments.experiment04.resource.DatabaseUtils;
import com.experiments.experiment04.service.StudentService;
import com.experiments.experiment04.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        addStudent();
        listStudentsByYear();
        listStudentsNames();
    }
    public static void addStudent(){
        StudentService studentService = new StudentServiceImpl();
        // 添加学生并获取更新后的学生列表
        List<Student> updatedStudents = studentService.addStudent(new Student(2022212880, Student.Sex.FEMALE, "董玉清", 2022));

        // 打印更新后的学生列表
        System.out.println("学生添加成功，更新后的学生列表：");
        for (Student student : updatedStudents) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Sex: " + student.getSex() + ", Year: " + student.getYear());
        }
    }
    public static void listStudentsByYear(){
        StudentService studentService = new StudentServiceImpl();
        // 获取2022级学生列表
        List<Student> students2022 = studentService.listStudentsByYear(2022);

        // 打印2022级学生信息
        System.out.println("2022级学生信息:");
        for (Student student : students2022) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Sex: " + student.getSex() + ", Year: " + student.getYear());
        }
    }
    public static void listStudentsNames(){
        StudentService studentService = new StudentServiceImpl();
        List<String> students = studentService.listStudentsNames(2022,Student.Sex.FEMALE);
        System.out.println("2022级女生姓名列表:");
        for (String s : students) {
            System.out.println(s + " ");
        }
    }
}
