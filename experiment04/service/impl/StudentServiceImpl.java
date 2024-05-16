package com.experiments.experiment04.service.impl;

import com.experiments.experiment04.entity.Student;
import com.experiments.experiment04.service.StudentService;
import com.experiments.experiment04.resource.DatabaseUtils;

import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> addStudent(Student student) {
        List<Student> students = DatabaseUtils.getStudents();
        students.add(student);
        return students;
    }

    @Override
    public List<Student> listStudentsByYear(int year) {
        return DatabaseUtils.getStudents().stream()
                .filter(student -> student.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listStudentsNames(int year, Student.Sex sex) {
        return DatabaseUtils.getStudents().stream()
                .filter(student -> student.getYear() == year && student.getSex() == sex)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> listStudentsByYearSortedById(int year) {
        return DatabaseUtils.getStudents().stream()
                .filter(student -> student.getYear() == year)
                .sorted(Comparator.comparingInt(Student::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Map<Student.Sex, List<Student>> listStudentsMapBySex() {
        return DatabaseUtils.getStudents().stream()
                .collect(Collectors.groupingBy(Student::getSex));
    }

    @Override
    public Map<Integer, Student> listStudentsByYearMapById(int year) {
        return DatabaseUtils.getStudents().stream()
                .filter(student -> student.getYear() == year)
                .collect(Collectors.toMap(Student::getId, student -> student));
    }

    @Override
    public boolean removeStudent(int id) {
        List<Student> students = DatabaseUtils.getStudents();
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();

        if (studentOptional.isPresent()) {
            students.remove(studentOptional.get());
            return true;
        }
        return false;
    }
}
