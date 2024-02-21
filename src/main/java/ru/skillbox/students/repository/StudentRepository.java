package ru.skillbox.students.repository;

import ru.skillbox.students.model.Student;

import java.util.List;

public interface StudentRepository {

    void add(Student student);
    void remove(Long id);
    void removeAll();
    List<Student> getAll();
}
