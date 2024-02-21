package ru.skillbox.students.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.skillbox.students.model.Student;

@Getter
public class StudentAddEvent extends ApplicationEvent {

    private final Student student;

    public StudentAddEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
