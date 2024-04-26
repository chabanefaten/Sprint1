package com.faten.parfums;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.faten.parfums.entities.Parfum;
import com.faten.parfums.service.ParfumService;

@SpringBootApplication
public abstract class Sprint1Application implements CommandLineRunner{
	@Autowired
	ParfumService parfumService;
	public static void main(String[] args) {
		SpringApplication.run(Sprint1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	parfumService.saveParfum(new Parfum("La vie est belle", 2600.0, new Date()));
	parfumService.saveParfum(new Parfum("You", 2800.0, new Date()));
	parfumService.saveParfum(new Parfum("Laurence", 900.0, new Date()));
	}

}
