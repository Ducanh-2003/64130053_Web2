package ntu.edu.vn.anh.sb_bmical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "controllers")
public class SbBmiCalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbBmiCalApplication.class, args);
	}

}
