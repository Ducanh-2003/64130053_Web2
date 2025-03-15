package ntu.edu.vn.anh.chaospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "controllers")
public class ChaoSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaoSpringBootApplication.class, args);
    }

}
