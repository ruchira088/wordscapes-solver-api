package com.ruchij.webapp;

import com.ruchij.WordscapesSolver;
import com.ruchij.data.ResourceFileWordImporter;
import com.ruchij.models.Node;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

	@Bean
	WordscapesSolver wordscapesSolver() {
		ResourceFileWordImporter resourceFileWordImporter = new ResourceFileWordImporter();
		Node<Character> data = resourceFileWordImporter.importData();

		return new WordscapesSolver(data);
	}

}
