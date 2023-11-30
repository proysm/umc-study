package umc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing		// JpaAuditing 사용이 가능하도록 변경해주어야 한다.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
