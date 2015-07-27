package com.cdg.kakaotalk;

public class Main {

	private static String INPUT_FILE = "KaKaoTalk.txt";

	public static void main(String[] args) {

		FileInput fileInput = new FileInput(INPUT_FILE);
		Analyzer analyzer = new Analyzer(fileInput);

		analyzer.distribute();
		analyzer.print();

	}

}
