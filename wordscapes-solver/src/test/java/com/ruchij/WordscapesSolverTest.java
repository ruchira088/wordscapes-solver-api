package com.ruchij;

import com.ruchij.data.WordImporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordscapesSolverTest {

	@Test
	void shouldReturnExpectedListOfWords() {
		WordImporter wordImporter = WordImporter.create("ac", "ai", "ti", "hi", "th", "tahi", "this", "hit");
		WordscapesSolver wordscapesSolver = new WordscapesSolver(wordImporter.importData());

		List<String> result = wordscapesSolver.findValues("thi");
		Assertions.assertEquals(List.of("hit", "hi", "th", "ti"), result);
	}

}