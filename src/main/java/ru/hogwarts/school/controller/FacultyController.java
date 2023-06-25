package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    // Получить факультет по идентификатору
    @GetMapping("{id}") // GET http://localhost:8080/faculty/1
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        // Если факультета нет, возвращаем 400
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        // Если такой факультет есть, получаем его
        return ResponseEntity.ok(faculty);
    }

    // Получение всех факультетов
    @GetMapping // GET http://localhost:8080/faculty
    public ResponseEntity<Collection<Faculty>> getAllFaculties() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    // Создание факультета
    @PostMapping // POST http://localhost:8080/faculty
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    // Редактирвоание факультета по идентификатору
    @PutMapping ("{id}")// PUT http://localhost:8080/faculty
    public ResponseEntity<Faculty> editFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(id, faculty);
        // Если факультета нет, возвращаем 400
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Запрос был выполнен не правильно
        }
        // Если такой факультет есть, получаем его
        return ResponseEntity.ok(foundFaculty);
    }

    // Удаление факультета по идентификатору
    @DeleteMapping("{id}") // DELETE http://localhost:8080/faculty/1
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

}
