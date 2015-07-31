package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Printer {

	public void timePrint(Map<String, Integer> map) {

		StringBuffer buffer = new StringBuffer();
		List list = sortMap(map);

		Iterator it = list.iterator();
		String str = it.next().toString();

		buffer.append("가장 많이 대화하는 시간대: ");
		buffer.append(str.substring(0, str.indexOf("=")) + "시\n");

		System.out.println(buffer);
	}

	public void peoplePrint(String name, Map<String, Integer> map) {

		StringBuffer buffer = new StringBuffer();
		List list = sortMap(map);

		buffer.append(name + "\n");

		Iterator it = list.iterator();

		for (int i = 0; i < 3; i++) {
			String str = it.next().toString();
			buffer.append((i + 1) + ". ");
			buffer.append(str.substring(0, str.indexOf("=")) + "\n");
		}

		System.out.println(buffer);
	}

	private List sortMap(Map<String, Integer> map) {
		Set set = map.entrySet();
		List list = new ArrayList(set);
		Collections.sort(list, new ValueComparator());
		return list;
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
