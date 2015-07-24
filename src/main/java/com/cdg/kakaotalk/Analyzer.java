package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Analyzer {

	private FileInput fileInput;
	private List<String> lineList = new ArrayList<String>();

	Time time = new Time();
	People people1 = new People("이선민");
	People people2 = new People("임승한");

	public Analyzer(FileInput fileInput) {
		this.fileInput = fileInput;
	}

	public void distribute() {

		lineList = fileInput.read();

		ListIterator<String> it = lineList.listIterator();

		while (it.hasNext()) {

			String str = (String) it.next();
			String[] sp = str.split("] ", 3);

			time.add(sp[1]);

			String name = people1.getName();
			// String name = sp[0].substring(1);

			if (people1.getName().equals(name)) {
				people1.calculate(sp[2]);
			} else {
				people2.calculate(sp[2]);
			}

		}

	}

	public void print() {
		time.print();
		people1.print();
		people2.print();
	}
}
