package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Добавление студента
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Поиск студента по идентифиактору
    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    // Редактирование студента по идентификатору
    public Student editStudent(long id, Student student) {
        return studentRepository.save(student);
    }

    // Удаление студента по идентификатору
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    // Отображение всех студентов
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
