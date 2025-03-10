package com.restapidemo.services;

import com.restapidemo.entities.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();
    Course getCourse(long courseId);
    Course addCourse(Course course);
    boolean deleteCourse(long courseId);
    Course updateCourse(long courseId, Course updatedcourse);
}
