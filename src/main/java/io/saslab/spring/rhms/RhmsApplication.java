package io.saslab.spring.rhms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableSwagger2
@SpringBootApplication
public class RhmsApplication {

	//private static final Logger LOGGER= LoggerFactory.getLogger(RhmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RhmsApplication.class, args);
		//LOGGER.info("employee service {} ",1);
	}

}
