package com.restapidemo.services;

import com.restapidemo.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceimpl implements CourseService{

    List<Course> list;

    public CourseServiceimpl() {
        list = new ArrayList<>();
        list.add(new Course(1,"java","learn about java"));
        list.add(new Course(2,"Spring boot","learn about spring boot"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {

        for(Course tempcourse : list) {
            if(tempcourse.getId() == courseId) {
                return tempcourse;
            }
        }
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public boolean deleteCourse(long courseId) {
        return list.removeIf(course -> course.getId() == courseId);
    }

    @Override
    public Course updateCourse(long courseId, Course updatedcourse) {
        for(Course tempcourse : list) {
            if (tempcourse.getId() == courseId) {
                tempcourse.setTitle(updatedcourse.getTitle());
                tempcourse.setDescription(updatedcourse.getDescription());
                return tempcourse;
            }
        }
        return null;
    }
}
