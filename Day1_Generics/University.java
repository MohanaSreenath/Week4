package Bridgelabz.Generics;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }
}

class Department {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public List<Course<? extends CourseType>> getCourses() {
        return courses;
    }

    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName());
        }
    }
}

public class University {
    public static void main(String[] args) {
        Department department = new Department();

        Course<ExamCourse> mathCourse = new Course<>(new ExamCourse("Mathematics"));
        Course<AssignmentCourse> programmingCourse = new Course<>(new AssignmentCourse("Programming"));
        Course<ResearchCourse> aiCourse = new Course<>(new ResearchCourse("Artificial Intelligence"));

        department.addCourse(mathCourse);
        department.addCourse(programmingCourse);
        department.addCourse(aiCourse);

        System.out.println("Courses Offered:");
        for (Course<? extends CourseType> course : department.getCourses()) {
            System.out.println(course.getCourseType().getCourseName());
        }
    }
}