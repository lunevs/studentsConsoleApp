package ru.skillbox.students.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventsListener {

    @EventListener
    public void studentAddEvent(StudentAddEvent addEvent) {
        System.out.println("Added student: " + addEvent.getStudent());
    }

    @EventListener
    public void studentRemoveEvent(StudentRemoveEvent removeEvent) {
        System.out.println("Removed student: " + removeEvent.getId());
    }

    @EventListener
    public void studentRemoveAllEvent(StudentRemoveAllEvent removeAllEvent) {
        System.out.println("Removed " + removeAllEvent.getStudentsNum() + " students");
    }
}
