package com.ruchij.data;

import com.ruchij.models.Node;

import java.util.List;
import java.util.stream.Stream;

public interface WordImporter {
	static WordImporter create(String... words) {
		return new ListWordImporter(List.of(words));
	}

	Stream<String> words();

	default Node<Character> importData() {
		Node<Character> root = Node.root();

		words().forEach(word -> {
			List<Character> characters = word.chars().mapToObj(character -> (char) character).toList();
			root.insert(characters);
		});

		return root;
	}
}

