package ru.skillbox.students.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.skillbox.students.event.StudentAddEvent;
import ru.skillbox.students.event.StudentRemoveAllEvent;
import ru.skillbox.students.event.StudentRemoveEvent;
import ru.skillbox.students.model.Student;
import ru.skillbox.students.repository.StudentRepository;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ApplicationEventPublisher eventPublisher;

    @ShellMethod("Add a new Student")
    public void add(String firstName, String lastName, int age) {
        Student student = new Student()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age);
        studentRepository.add(student);
        eventPublisher.publishEvent(new StudentAddEvent(this, student));
    }

    @ShellMethod("Remove a Student")
    public void remove(Long id) {
        studentRepository.remove(id);
        eventPublisher.publishEvent(new StudentRemoveEvent(this, id));
    }

    @ShellMethod("List all Students")
    public void list() {
        List<Student> studentList = studentRepository.getAll();
        studentList.forEach(System.out::println);
    }

    @ShellMethod("Remove all Students")
    public void removeAll() {
        int size = studentRepository.getAll().size();
        studentRepository.removeAll();
        eventPublisher.publishEvent(new StudentRemoveAllEvent(this, size));
    }
}
