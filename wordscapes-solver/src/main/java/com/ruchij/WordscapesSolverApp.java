package com.ruchij;

import com.ruchij.data.ResourceFileWordImporter;
import com.ruchij.data.WordImporter;
import com.ruchij.model.Node;

import java.util.List;

public class WordscapesSolverApp {
	public static void main(String[] args) {
		WordImporter wordImporter = WordImporter.create("ac", "ai", "ti", "hi", "th", "tahi", "this");
		Node<Character> data = wordImporter.importData();
		WordscapesSolver wordscapesSolver = new WordscapesSolver(data);
//
		System.out.println(wordscapesSolver.findValues(List.of('t', 'i', 'h')));

		new ResourceFileWordImporter("words.txt").words().limit(10).forEach(System.out::println);
	}
}
