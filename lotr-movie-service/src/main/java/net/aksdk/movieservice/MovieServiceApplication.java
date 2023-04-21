package net.aksdk.movieservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Lord of The Rings Movie Service REST APIs",
				description = "Lord of The Rings Movie Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Alex",
						email = "shtirlitz@gmail.com",
						url = "https://github.com/sf-shtirlitz/AlexKhodorenko-SDK"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/sf-shtirlitz/AlexKhodorenko-SDK"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Lord of The Rings Movie",
				url = "https://github.com/sf-shtirlitz/AlexKhodorenko-SDK"
		)
)
@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
public class MovieServiceApplication {

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
