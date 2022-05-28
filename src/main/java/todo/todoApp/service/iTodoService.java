package todo.todoApp.service;

import org.springframework.stereotype.Service;
import todo.todoApp.model.Todo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface iTodoService {

    List<Todo> getTodosByUser(String user);

    Optional<Todo> getTodoById(long id);

    void updateTodo(Todo todo);

    void addTodo(String name, String desc, Date targetDate, boolean isDone);

    void deleteTodo(long id);

    void saveTodo(Todo todo);

}
