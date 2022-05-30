package todo.todoApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import todo.todoApp.model.Todo;
import todo.todoApp.repository.TodoRepository;

@DataJpaTest
public class todoRepositoryTests {

    @Autowired
    TodoRepository todoRepository;

    @Test
    public void saveTodoTest(){
        Todo todos = new Todo(){


        }
    }
}
