package com.bishop.javahexgonaapirest;

import com.bishop.javahexgonaapirest.infrastructure.adapters.output.persistence.entity.StudentEntity;
import com.bishop.javahexgonaapirest.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class JavaHexgonaApirestApplication implements CommandLineRunner {
    private final StudentRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(JavaHexgonaApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<StudentEntity> entities = Arrays.asList(
				new StudentEntity(null,"Sergio","Antozzi",40,"Calle 1")
		);
		repository.saveAll(
				entities
		);
 	}
}
