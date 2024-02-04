package com.ruchij.webapp.controllers;

import com.ruchij.WordscapesSolver;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/solver", produces = MediaType.APPLICATION_JSON_VALUE)
public class WordscapesSolverController {
	private final WordscapesSolver wordscapesSolver;

	public WordscapesSolverController(WordscapesSolver wordscapesSolver) {
		this.wordscapesSolver = wordscapesSolver;
	}

	@GetMapping
	public List<String> words(@RequestParam List<Character> chars) {
		return wordscapesSolver.findValues(chars);
	}

	@GetMapping("/{characters}")
	public List<String> words(@PathVariable String characters) {
		return wordscapesSolver.findValues(characters);
	}
}
