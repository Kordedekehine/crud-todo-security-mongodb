package todo.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import todo.todoApp.model.Todo;

import java.util.List;
@Repository
public interface TodoRepository extends MongoRepository<Todo,Long> {
    List<Todo> findByUserName(String username);

    List<Todo> findByDescription(String description);
}
