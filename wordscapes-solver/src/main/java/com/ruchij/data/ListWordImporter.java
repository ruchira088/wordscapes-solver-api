package com.ruchij.data;

import java.util.List;
import java.util.stream.Stream;

public class ListWordImporter implements WordImporter {
	private final List<String> wordsList;

	public ListWordImporter(List<String> wordsList) {
		this.wordsList = wordsList;
	}

	@Override
	public Stream<String> words() {
		return wordsList.stream();
	}
}
