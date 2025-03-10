package com.restapidemo.Controller;

import com.restapidemo.entities.Course;
import com.restapidemo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {


    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "this is home page";
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable("courseID") Long courseId) {
        return this.courseService.getCourse(courseId);
    }

    @PostMapping("/courses")
    public Course addCouse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseID") Long courseId) {
        boolean deleted = this.courseService.deleteCourse(courseId);
        if (deleted) {
            return ResponseEntity.ok("Course deleted successfully with ID: " + courseId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/courses/{courseID}")
    public ResponseEntity<Course> updateCourse(@PathVariable("courseID") long courseId, @RequestBody Course updatedcourse) {
        Course course = this.courseService.updateCourse(courseId, updatedcourse);
        if (course != null) {
            return ResponseEntity.ok(course); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
