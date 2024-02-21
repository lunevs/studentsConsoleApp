package ru.skillbox.students.event;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.skillbox.students.service.StudentService;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "app.init-on-startup", havingValue = "true")
public class StartupInit {

    private final StudentService studentService;

    @EventListener(ApplicationStartedEvent.class)
    public void addStudents() {
        studentService.add("Ivan", "Ivanov", 25);
        studentService.add("Petr", "Petrov", 30);
        studentService.add("Maria", "Sidorova", 18);
    }
}
