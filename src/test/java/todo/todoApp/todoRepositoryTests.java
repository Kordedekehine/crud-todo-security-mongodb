package todo.todoApp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import todo.todoApp.model.Todo;
import todo.todoApp.repository.TodoRepository;

import java.sql.Date;

//@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class todoRepositoryTests {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void saveTodoTest(){
     Todo todo = new Todo();
     todo.setUserName("korede");
     todo.setDescription("i wanna go to the gym");
     todo.setId(1L);
     todo.setTargetDate(Date.valueOf("12/02/2023"));

     todoRepository.save(todo);
     Assertions.assertThat(todo.getId()).isGreaterThan(0);
        }

        public void getTodoTest(){
        Todo todo = todoRepository.findById(1L).get();
        Assertions.assertThat(todo.getId()).isEqualTo(1L);
        }
    }

