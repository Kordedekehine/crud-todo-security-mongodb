package todo.todoApp.service;

import org.springframework.stereotype.Service;
import todo.todoApp.model.Todo;
import todo.todoApp.repository.TodoRepository;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BasicService {


    private final TodoRepository todoRepository;

    public BasicService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void addTodo(Todo todo) {
        List<Todo> addTodos = todoRepository.findByUserName(todo.getUserName());
        if (addTodos.isEmpty()) {
            throw new IllegalArgumentException("Todos not saved");
        }
        todoRepository.save(todo);
    }

    public List<Todo> getAllStudents() {
        return todoRepository.findAll();
    }

    public void deleteTodos(long id) {
        Boolean todos = todoRepository.existsById(id);
        if (!todos) {
            throw new IllegalStateException("The " + id + " does not exist");
        }
        todoRepository.deleteById(id);
    }

    public void updateTodo(Long id, String username, String description, Date target) {

        Todo todos = todoRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "The To-do  with " + id + " does not exist"
        ) );

        if (username != null && username.length() > 0 && !Objects.equals(todos.getUserName(),username)){
            todos.setUserName(username);
        }


        if (description != null && description.length() > 0 && !Objects.equals(todos.getDescription(), description)) {
            List<Todo> todoOptional = todoRepository.findByDescription(description);
            if (todoOptional.isEmpty()) {
                todos.setDescription(description);
            }
            throw new IllegalStateException("Scheduled Already.");
        }

        if (target != null  && !Objects.equals(todos.getTargetDate(),target)){
            todos.setTargetDate(target);
        }
    }
}
