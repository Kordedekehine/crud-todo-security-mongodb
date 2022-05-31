package todo.todoApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//(exclude = {DataSourceAutoConfiguration.class})
//@EnableMongoRepositories
@SpringBootApplication
public class KoredeTodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KoredeTodoAppApplication.class, args);
	}


}
