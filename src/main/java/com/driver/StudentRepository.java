package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        studentMap.put(student.toString(),student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.toString(),teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            List<String> temp = new ArrayList<String>();
            temp.add(student.toString());
            temp.add(teacher.toString());
            teacherStudentMapping.put(temp.toString(),temp);
        }
    }

    public Student findStudent(String student){
        // your code goes here
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        List<String> res =new ArrayList<>();
        HashMap<String, List<String>> temp = teacherStudentMapping;
        for(List<String> temp2:teacherStudentMapping.values()){
            if(teacher.equalsIgnoreCase(temp2.get(1))){
                res.add(temp2.get(0));
            }
        }
        return res;
    }

    public List<String> findAllStudents(){
        // your code goes here
        List<String> res = (List<String>) studentMap.keySet();
        return res;
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        teacherMap.remove(teacher);
    }

    public void deleteAllTeachers(){
        // your code goes here
        teacherMap.clear();
    }
}