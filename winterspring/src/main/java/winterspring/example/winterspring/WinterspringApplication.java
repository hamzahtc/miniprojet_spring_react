package winterspring.example.winterspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "winterspring.example.winterspring.repository")
@SpringBootApplication
public class WinterspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WinterspringApplication.class, args);
	}
}