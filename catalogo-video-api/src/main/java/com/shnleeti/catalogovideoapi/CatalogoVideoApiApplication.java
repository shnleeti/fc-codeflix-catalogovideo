package com.shnleeti.catalogovideoapi;

import com.shnleeti.catalogovideoapi.domain.entity.Category;
import com.shnleeti.catalogovideoapi.domain.entity.Genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoVideoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoVideoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Genre genre = new Genre("Gente 1");

		Category category = new Category("Category 1");
		Category category2 = new Category("Category 2");

		genre.addCategory(category);
		System.out.println("Gente " + genre.toString());
		genre.addCategory(category2);
		System.out.println("Gente " + genre.toString());
		genre.removeCategory(category);
		System.out.println("Gente " + genre.toString());
		
	}

	

}
