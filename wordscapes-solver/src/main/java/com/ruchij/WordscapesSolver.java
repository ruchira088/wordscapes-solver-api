package com.ruchij;

import com.ruchij.models.Node;

import java.util.*;
import java.util.stream.Collectors;

public class WordscapesSolver {
	private final Node<Character> data;

	public WordscapesSolver(Node<Character> data) {
		this.data = data;
	}

	public List<String> findValues(String characters) {
		return findValues(characters.chars().mapToObj(character -> (char) character).toList());
	}

	public List<String> findValues(List<Character> characters) {
		Comparator<String> sortByLength = Comparator.comparing(String::length).reversed();
		Comparator<String> comparator = sortByLength.thenComparing(Comparator.naturalOrder());
		return findValues(characters, data).stream().sorted(comparator).toList();
	}

	private Set<String> findValues(List<Character> characters, Node<Character> node) {
		Set<String> values = new HashSet<>();

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
