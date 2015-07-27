package com.cdg.kakaotalk;

import java.util.HashMap;
import java.util.Map;

public class Word {

	private Map<String, Integer> map = new HashMap<String, Integer>();

	Word() {
	}

	public void add(String s) {

		String[] sp = s.split(" ");		// sp = "사진 안녕 등등등"

		for (int i = 0; i < sp.length; i++) {

			if (map.containsKey(sp[i])) {
				int count = map.get(sp[i]);
				map.replace(sp[i], ++count);
			} else {
				map.put(sp[i], 1);
			}
		}
	}

	
	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

}
