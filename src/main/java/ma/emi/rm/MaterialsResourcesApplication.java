package ma.emi.rm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ma.emi.rm","it.ozimov.springboot"})
public class MaterialsResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaterialsResourcesApplication.class, args);
	}
}
