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
    public List<Todo> getTodosByUser(String user) {
        return todoRepository.findByUserName(user);
    }

    @Override
    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
      todoRepository.save(new Todo(name,desc,targetDate,isDone));
    }

    @Override
    public void deleteTodo(long id) {
      Optional<Todo>  todo = todoRepository.findById(id);
      if (todo.isPresent()){
          todoRepository.deleteById(id);
      }

        todoRepository.deleteById(id);
    }

    @Override
    public void saveTodo(Todo todo) {
     todoRepository.save(todo);
    }
}
