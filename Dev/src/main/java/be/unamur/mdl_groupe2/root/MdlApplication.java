package be.unamur.mdl_groupe2.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class MdlApplication {

	public static void main(String[] args) {

		SpringApplication.run(MdlApplication.class, args);
	}

}
