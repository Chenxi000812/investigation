package com.chenxi.investigation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.chenxi.investigation.domain.dao")
@EnableTransactionManagement
public class InvestigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestigationApplication.class, args);
    }

}
