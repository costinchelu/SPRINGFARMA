package ro.springmongo.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@SpringBootApplication
@EnableMongoRepositories("ro.springmongo.repository")
@ComponentScan("ro.springmongo.*")
public class SpringMongoApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApp.class, args);
    }
}
