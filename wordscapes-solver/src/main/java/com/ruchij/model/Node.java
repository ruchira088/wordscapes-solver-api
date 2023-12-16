package com.ruchij.model;

import java.util.*;

public record Node<T>(List<T> path, T value, Map<T, Node<T>> children) {
	public static <T> Node<T> root() {
		return new Node<>(new ArrayList<>(), null, new HashMap<>());
	}

	public void insert(List<T> values) {
		insert(values.iterator());
	}

	public void insert(T[] values) {
		insert(Arrays.stream(values).iterator());
	}

	public void insert(Iterator<T> values) {
		T next = values.hasNext() ? values.next() : null;

		Node<T> childNode =
			children.computeIfAbsent(
				next,
				__ -> {
					List<T> nextPath = new ArrayList<>(path);

					if (next != null) {
						nextPath.add(next);
					}

					return new Node<>(nextPath, next, new HashMap<>());
				}
			);

		if (next != null){
			childNode.insert(values);
		}
	}
}
