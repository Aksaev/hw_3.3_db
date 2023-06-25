package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Получить студента по идентификатору
    @GetMapping("{id}") // GET http://localhost:8080/student/1
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        // Если студента нет, возвращаем 400
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        // Если такой студент есть, получаем его
        return ResponseEntity.ok(student);
    }

    // Получение всех студентов
    @GetMapping // GET http://localhost:8080/student
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // Создание студента
    @PostMapping // POST http://localhost:8080/student
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // Редактирвоание студента по идентификатору
    @PutMapping("{id}") // PUT http://localhost:8080/student/1
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable Long id) {
        Student foundStudent = studentService.editStudent(id, student);
        // Если студента нет, возвращаем 400
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Запрос был выполнен не правильно
        }
        // Если такой студент есть, получаем его
        return ResponseEntity.ok(foundStudent);
    }

    // Удаление студента по идентификатору
    @DeleteMapping("{id}") // DELETE http://localhost:8080/student/1
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}
