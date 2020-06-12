package java_uml;

import java.util.ArrayList;
import java.util.List;

public class Test{

    public static void main(String[] args) {
        
        //professor class 
        Professor p = new Professor();

        Course c = new Course();

        //set professor data 
        p.setEmpId(123);
        p.setOfficeNumber("1234567890");
        p.setName("Professor 1");


        c.setCourseID(1);
        c.setCourseName("Java");
        c.setDescription("In this course you will learn about basic java, oop");
        c.setProfessor(p);
        c.setYear(2020);
        c.setDept("CS");
        c.setSemester('F');

        //create new students and set courses
        Student student1 = new Student(1,20.0,"Name 1");
        Student student2 = new Student(1,40.0,"Name 2");
        Student student3 = new Student(1,30.0,"Name 3");
        student1.setCourse(c);
        student2.setCourse(c);

        //new course for student 3
        Course c1 = new Course();
        c1.setCourseID(2);
        student3.setCourse(c1);

        //list of student to be set in course.
        List<Student> sList = new ArrayList<>();
        sList.add(student1);
        sList.add(student2);
        sList.add(student3);
        
        c.setStudentList(sList);

        //getting average calculation
        System.out.println("Average marks in "+c.getCourseName()+" is "+c.getAverageMarksByCourseID(1));

    }
}