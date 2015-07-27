package com.cdg.kakaotalk;

import java.util.HashMap;
import java.util.Map;

public class Time {

	private Map<String, Integer> map = new HashMap<String, Integer>();

	public void analyze(String s) {

		if (map.containsKey(s)) {
			int count = map.get(s);
			map.replace(s, ++count);
		} else {
			map.put(s, 1);
		}
	}

	
	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

}
