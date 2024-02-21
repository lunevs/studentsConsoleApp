package ru.skillbox.students.repository;

import org.springframework.stereotype.Component;
import ru.skillbox.students.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MemoryStudentRepository implements StudentRepository {

    private final Map<Long, Student> studentMap = new HashMap<>();
    private final AtomicLong newId = new AtomicLong(1);

    @Override
    public void add(Student student) {
        student.setId(newId.getAndIncrement());
        studentMap.put(student.getId(), student);
    }

    @Override
    public void remove(Long id) {
        studentMap.remove(id);
    }

    @Override
    public void removeAll() {
        studentMap.clear();
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }
}
