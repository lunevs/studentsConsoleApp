package ru.skillbox.students.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentRemoveAllEvent extends ApplicationEvent {

    private final Integer studentsNum;

    public StudentRemoveAllEvent(Object source, Integer studentsNum) {
        super(source);
        this.studentsNum = studentsNum;
    }
}
