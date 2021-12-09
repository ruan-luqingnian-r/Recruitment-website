package com.ruan.Lagou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


@SpringBootApplication
@MapperScan("com.ruan.Lagou.mapper")
public class LagouApplication {

	public static void main(String[] args) {
		SpringApplication.run(LagouApplication.class, args);
	}

}
