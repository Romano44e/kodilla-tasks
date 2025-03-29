package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test Title", "test Description");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, task.getId());
        assertEquals("test Title", task.getTitle());
        assertEquals("test Description", task.getContent());

    }

    @Test
    void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "test Title", "test Description");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, taskDto.getId());
        assertEquals("test Title", taskDto.getTitle());
        assertEquals("test Description", taskDto.getContent());

    }

    @Test
    void testMapToTaskDtoList() {
        //Given
        List<Task> tasksList = new ArrayList<>();
        Task task = new Task(1L, "test Title", "test Description");
        tasksList.add(task);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasksList);

        //Then
        assertEquals(1, taskDtos.size());
        assertEquals("test Title", taskDtos.get(0).getTitle());

    }

}
