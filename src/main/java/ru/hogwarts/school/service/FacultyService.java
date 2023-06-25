package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // Добавление факультета
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Поиск факультета по идентифиактору
    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    // Редактирование факультета по идентификатору
    public Faculty editFaculty(long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Удаление факультета по идентификатору
    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    // Отображение всех факультета
    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

}