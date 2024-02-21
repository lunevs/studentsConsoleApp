package ru.skillbox.students.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentRemoveEvent extends ApplicationEvent {

    private final Long id;

    public StudentRemoveEvent(Object source, Long id) {
        super(source);
        this.id = id;
    }
}
