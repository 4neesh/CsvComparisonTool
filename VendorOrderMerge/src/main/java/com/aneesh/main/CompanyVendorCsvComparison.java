package com.aneesh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class CompanyVendorCsvComparison {

    @Bean
    public CsvBuilder createComparison() {
        return new CsvBuilder();
    }

    public static void main(String[] args) {
        SpringApplication.run(CompanyVendorCsvComparison.class, args);
    }

}
