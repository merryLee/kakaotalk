package com.cdg.kakaotalk;

import java.util.HashMap;
import java.util.Map;

public class Word {

	private Map<String, Integer> map = new HashMap<String, Integer>();

	Word() {
	}

	public void add(String s) {

		String[] sp = s.split(" "); 		// sp는 대화문장.

		for (int i = 0; i < sp.length; i++) {

			if (!sp[i].equals("")) {		// 빈값 추가 제외.

				if (map.containsKey(sp[i])) {
					int count = map.get(sp[i]);
					map.replace(sp[i], ++count);
				} else {
					map.put(sp[i], 1);
				}

			} //if
		} //for
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

}
