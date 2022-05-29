package todo.todoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.todoApp.model.Todo;
import todo.todoApp.repository.TodoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements iTodoService{

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getTodosByUser(String username) {
        return todoRepository.findByUserName(username);
    }

    @Override
    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String username, String desc, Date targetDate, boolean isDone) {
      todoRepository.save(new Todo(username,desc,targetDate,isDone));
    }

    @Override
    public String deleteTodo(long id) {
      Optional<Todo>  todo = todoRepository.findById(id);
      if (todo.isPresent()){
          todoRepository.deleteById(id);
      }

        todoRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public void saveTodo(Todo todo) {
     todoRepository.save(todo);
    }
}
