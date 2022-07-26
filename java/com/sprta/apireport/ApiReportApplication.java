package com.sprta.apireport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 업데이트 추적해줘 - timestamped
public class ApiReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiReportApplication.class, args);
    }

}
