package com.ruchij.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Stream;

public class ResourceFileWordImporter implements WordImporter {
	private static final String WORDS_LIST_FILE_NAME = "words.txt";

	private final String fileName;

	public ResourceFileWordImporter(String fileName) {
		this.fileName = fileName;
	}

	public ResourceFileWordImporter() {
		this(WORDS_LIST_FILE_NAME);
	}

	@Override
	public Stream<String> words() {
		try {
			URL resource = getClass().getClassLoader().getResource(fileName);

			if (resource == null) {
				throw new RuntimeException("Unable to find file resource named: " + fileName);
			}

			InputStreamReader reader = new InputStreamReader(resource.openStream());
			BufferedReader bufferedReader = new BufferedReader(reader);

			return bufferedReader.lines();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
