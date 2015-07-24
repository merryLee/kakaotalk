package com.cdg.kakaotalk;

public class People {

	private String name;
	private Word word;

	public People(String name) {
		this.name = name;
		
		word = new Word();
	}

	public void calculate(String s) {

		word.add(s);

	}

	public void print() {
		System.out.println(name);
		word.print();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

}
