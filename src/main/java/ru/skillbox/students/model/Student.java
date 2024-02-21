package ru.skillbox.students.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.text.MessageFormat;

@Getter
@Setter
@Accessors(chain = true)
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return MessageFormat.format("id: {0}, full name: {1} {2}, age: {3}", id, firstName, lastName, age);
    }
}
