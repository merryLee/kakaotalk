package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Word {

	private Map<String, Integer> map = new HashMap<String, Integer>();

	Word() {
	}

	public void add(String s) {

		// s="사진 안녕 등등등"
		String[] sp = s.split(" ");

		for (int i = 0; i < sp.length; i++) {

			if (map.containsKey(sp[i])) {
				int count = map.get(sp[i]);
				map.replace(sp[i], ++count);
			} else {
				map.put(sp[i], 1);
			}

		}

	}

	public void print() {

		Set set = map.entrySet();
		List list = new ArrayList(set);

		Collections.sort(list, new ValueComparator());

		Iterator it = list.iterator();

		for (int i = 0; i < 3; i++) {
			String str = it.next().toString();
			System.out.println(str);
		}
	}

	static class ValueComparator implements Comparator {
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;

				int v1 = ((Integer) e1.getValue()).intValue();
				int v2 = ((Integer) e2.getValue()).intValue();

				return v2 - v1;
			}
			return -1;
		}
	}

}
