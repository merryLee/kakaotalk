package com.cdg.kakaotalk;

import java.util.Map;

public class People {

	private String name;
	private Word word = new Word();

	private Map<String, Integer> map;

	public People(String name) {
		this.name = name;
	}

	public void analyze(String s) {

		word.add(s);
		map = word.getMap();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

}
