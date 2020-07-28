package com.aneesh;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import com.aneesh.csv.*;
import com.aneesh.data.*;

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
