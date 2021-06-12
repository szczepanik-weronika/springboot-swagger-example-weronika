package pl.bykowski.springbootswaggerexample;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentApi {

    private List<Student> studentList;

    public StudentApi() {
        this.studentList = new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Student getStudents(@PathVariable int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id).findFirst().get();
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentList;
    }

    @PostMapping
    public boolean addStudent(@RequestBody Student student) {
        return studentList.add(student);
    }
}
