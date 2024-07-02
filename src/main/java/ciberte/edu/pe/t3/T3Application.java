package ciberte.edu.pe.t3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class T3Application {

	public static void main(String[] args) {
		SpringApplication.run(T3Application.class, args);
	}

	@Bean
	public WebMvcConfigurer configGlobalCors(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("api/t3/**")
						.allowedMethods("GET","POST","PUT")
						.allowedOrigins("https://www.cibertec.edu.pe");
			}
		};
	}
}
