package com.experiments.experiment05.resource;

import com.experiments.experiment05.entity.College;
import com.experiments.experiment05.entity.Teacher;
import com.experiments.experiment05.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseUtils {
    public static List<Student> getStudents() {
        // 模拟数据  
        College college1 = new College("计控学院");
        College college2 = new College("机电学院");
        Teacher teacher1 = new Teacher("T001", "王波", college1);
        Teacher teacher2 = new Teacher("T002", "李冰", college2);

        List<Student> students = new ArrayList<>();
        students.add(new Student("2022212854", "lzk", 2022, teacher1));
        students.add(new Student("2022212888", "cl", 2022, teacher1));
        students.add(new Student("2022212861", "xzh", 2022, teacher2));
        students.add(new Student("2022222002", "lsy", 2022, teacher2));

        return students;
    }
}