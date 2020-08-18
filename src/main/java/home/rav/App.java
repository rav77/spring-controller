package home.rav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@PropertySource("classpath:user.properties")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
