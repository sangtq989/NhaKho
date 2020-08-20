package com.huyen.nhakho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.huyen.nhakho.entity", "com.huyen.nhakho.entity.relation"})
@EnableJpaRepositories("com.huyen.nhakho.repository")
public class NhakhoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NhakhoApplication.class, args);
    }

}
