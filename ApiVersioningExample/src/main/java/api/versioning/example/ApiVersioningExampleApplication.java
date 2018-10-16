package api.versioning.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mindstix.web.api.version.management.annotations.ApiVersionCheck;

@SpringBootApplication
@ApiVersionCheck
@ComponentScan(basePackages = { "com.mindstix.web", "api.versioning.example" })
public class ApiVersioningExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVersioningExampleApplication.class, args);
	}
}
