package com.ruchij;

import com.ruchij.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordscapesSolver {
	private final Node<Character> data;

	public WordscapesSolver(Node<Character> data) {
		this.data = data;
	}

	public List<String> findValues(List<Character> characters) {
		return findValues(characters, data);
	}

	private List<String> findValues(List<Character> characters, Node<Character> node) {
		List<String> values = new ArrayList<>();

		Node<Character> nullNode = node.children().get(null);

		if (nullNode != null) {
			values.add(nullNode.path().stream().map(Object::toString).collect(Collectors.joining()));
		}

		for (int i = 0; i < characters.size(); i++) {
			Character character = characters.get(i);

			Node<Character> nextNode = node.children().get(character);

			if (nextNode != null) {
				List<Character> nextCharacters = new ArrayList<>(characters);
				nextCharacters.remove(i);

				values.addAll(findValues(nextCharacters, nextNode));
			}
		}

		return values;
	}
}
