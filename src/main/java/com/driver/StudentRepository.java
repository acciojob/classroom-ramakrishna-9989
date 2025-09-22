package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository


public class StudentRepository {

    private Map<String, Student> studentMap;
    private Map<String, Teacher> teacherMap;
    private Map<String, List<String>> teacherStudentMapping;

    public StudentRepository() {
        this.studentMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
        this.teacherStudentMapping = new HashMap<>();
    }

    public void saveStudent(Student student) {
        studentMap.put(student.getName(), student); // assuming Student has getName()
    }

    public void saveTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher); // assuming Teacher has getName()
    }

    public void saveStudentTeacherPair(String student, String teacher) {
        if (studentMap.containsKey(student) && teacherMap.containsKey(teacher)) {
            teacherStudentMapping
                    .computeIfAbsent(teacher, k -> new ArrayList<>())
                    .add(student);
        }
    }

    public Student findStudent(String student) {
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher) {
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher) {
        return teacherStudentMapping.getOrDefault(teacher, Collections.emptyList());
    }

    public List<String> findAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher) {
        teacherMap.remove(teacher);
        teacherStudentMapping.remove(teacher); // also remove mapping
    }

    public void deleteAllTeachers() {
        teacherMap.clear();
        teacherStudentMapping.clear();
    }
}
