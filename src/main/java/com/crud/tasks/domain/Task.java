package com.crud.tasks.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "tasks")
public class Task {

    public Task(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String title;

    @Column(name = "description")
    private String content;

}
