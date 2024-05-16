// Test.java
package com.experiments.experiment05;

import com.experiments.experiment05.entity.College;
import com.experiments.experiment05.entity.Student;
import com.experiments.experiment05.entity.Teacher;
import com.experiments.experiment05.resource.DatabaseUtils;

import java.util.List;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        List<Student> students = DatabaseUtils.getStudents();

        // 测试根据学号查找学生
        String studentId = "2022212854";
        Optional<Student> studentOptional = findStudentById(students, studentId);
        handleStudentOptional(studentOptional);

        // 测试获取学生指导教师的学院名称
        Optional<String> collegeNameOptional = getAdvisorCollegeName(students, studentId);
        handleCollegeNameOptional(collegeNameOptional);
    }

    /**
     * 根据学号查找学生
     *
     * @param students 学生列表
     * @param id       学号
     * @return 包含学生信息的Optional，如果不存在则返回空Optional
     */
    public static Optional<Student> findStudentById(List<Student> students, String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    /**
     * 处理学生Optional，避免空指针异常
     *
     * @param studentOptional 学生Optional
     */
    public static void handleStudentOptional(Optional<Student> studentOptional) {
        studentOptional.ifPresentOrElse(
                student -> System.out.println("找到学生: " + student.getName()),
                () -> System.out.println("未找到学生")
        );
    }

    /**
     * 获取学生指导教师的学院名称
     *
     * @param students 学生列表
     * @param id       学号
     * @return 包含学院名称的Optional，如果不存在则返回空Optional
     */
    public static Optional<String> getAdvisorCollegeName(List<Student> students, String id) {
        return findStudentById(students, id)
                .flatMap(student -> Optional.ofNullable(student.getAdvisor()))
                .map(Teacher::getCollege)
                .map(College::getName);
    }

    /**
     * 处理学院名称Optional，避免空指针异常
     *
     * @param collegeNameOptional 学院名称Optional
     */
    public static void handleCollegeNameOptional(Optional<String> collegeNameOptional) {
        collegeNameOptional.ifPresentOrElse(
                collegeName -> System.out.println("指导教师所在学院: " + collegeName),
                () -> System.out.println("未找到指导教师或指导教师没有所属学院")
        );
    }
}
