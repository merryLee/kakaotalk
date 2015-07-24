package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Time {

	private Map<String, Integer> map = new HashMap<String, Integer>();

	public void add(String s) {

		s = s.substring(1, s.indexOf(":"));

		if (map.containsKey(s)) {
			int count = map.get(s);
			map.replace(s, ++count);
		} else {
			map.put(s, 1);
		}

	}

	public void print() {

		Set set = map.entrySet();
		List list = new ArrayList(set);

		Collections.sort(list, new ValueComparator());

		Iterator it = list.iterator();
		String str = it.next().toString();
		System.out.println("가방많이 대화하는 시간대: " + str);

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