package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DbServiceTestSuite {

    @Autowired
    private DbService dbService;

    @Test
    void testGetTask() throws TaskNotFoundException {
        //Given
        //When
        Task task = dbService.getTask(2L);

        //Then
        assertNotNull(task);
        assertEquals("zadanie nr 1", task.getTitle());

    }


    @Test
    void testAllGetTasks() {
        //Given
        //When
        List<Task> tasks = dbService.getAllTasks();

        //Then
        assertNotNull(tasks);
        assertEquals("zadanie nr 1", tasks.get(0).getTitle());

    }

    @Test
    void testGetTaskById() {
        //Given
        //When
        Task task = dbService.getTaskById(2L);

        //Then
        assertNotNull(task);
        assertEquals("zadanie nr 1", task.getTitle());

    }

    @Test
    void testSaveTask() {
        //Given
        Task task = new Task("zadanie nr 3", "pozmywać naczynia");

        //When
        Task task1 = dbService.saveTask(task);

        //Then
        assertEquals("zadanie nr 3", task1.getTitle());
        assertNotNull(task1);

    }

    @Test
    void testDeleteTask() {
        //Given
        Task task = new Task("test task", "test content");
        Task task1 = dbService.saveTask(task);

        //When
        dbService.deleteTask(task1.getId());

        //Then
        assertNull(dbService.getTaskById(task1.getId()));

    }

}
