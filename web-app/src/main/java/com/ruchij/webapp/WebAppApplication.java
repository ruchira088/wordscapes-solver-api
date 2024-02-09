package com.ruchij.webapp;

import com.ruchij.WordscapesSolver;
import com.ruchij.data.ResourceFileWordImporter;
import com.ruchij.models.Node;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.time.Clock;
import java.util.Properties;

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

	@Bean
	PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
			new PropertySourcesPlaceholderConfigurer();

		propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("git.properties"));

		return propertySourcesPlaceholderConfigurer;
	}

	@Bean
	Properties systemProperties() {
		return System.getProperties();
	}

	@Bean
	Clock clock() {
		return Clock.systemDefaultZone();
	}
}
