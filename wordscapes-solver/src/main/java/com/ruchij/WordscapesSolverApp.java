package com.ruchij;

import com.ruchij.data.ResourceFileWordImporter;
import com.ruchij.data.WordImporter;
import com.ruchij.models.Node;

public class WordscapesSolverApp {
	public static void main(String[] args) {
		WordImporter wordImporter = WordImporter.create("ac", "ai", "ti", "hi", "th", "tahi", "this", "hit");
		ResourceFileWordImporter resourceFileWordImporter = new ResourceFileWordImporter();
//		Node<Character> data = wordImporter.importData();
		Node<Character> data = resourceFileWordImporter.importData();
		WordscapesSolver wordscapesSolver = new WordscapesSolver(data);

		System.out.println(wordscapesSolver.findValues("rusge"));

	}
}
