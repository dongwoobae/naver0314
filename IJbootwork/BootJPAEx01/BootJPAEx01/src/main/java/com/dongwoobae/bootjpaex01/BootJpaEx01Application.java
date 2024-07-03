package com.dongwoobae.bootjpaex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"mycar.*","naver.storage","com.dongwoobae.bootjpaex01"})
@EntityScan("mycar.data")
@EnableJpaRepositories("mycar.repository")
public class BootJpaEx01Application {

    public static void main(String[] args) {
        SpringApplication.run(BootJpaEx01Application.class, args);
    }

}
