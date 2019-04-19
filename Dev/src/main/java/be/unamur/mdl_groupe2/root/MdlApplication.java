package be.unamur.mdl_groupe2.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.*;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"be.unamur.mdl_groupe2.root.repositories"})
@EntityScan(basePackages = {"be.unamur.mdl_groupe2.root.models"})
@EnableTransactionManagement
public class MdlApplication {
    public static void main(String[] args) throws Exception {
        new SpringApplication(MdlApplication.class).run(args);
    }
}
