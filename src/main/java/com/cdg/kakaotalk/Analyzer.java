package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {

	private FileInput fileInput;
	private FileOutput fileOutput = new FileOutput();
	private List<String> lineList = new ArrayList<String>();

	Time time = new Time();
	People people1 = new People("이선민");
	People people2 = new People("임승한");

	public Analyzer(FileInput fileInput) {
		this.fileInput = fileInput;
	}

	public void distribute() {

		lineList = fileInput.read();

		Iterator<String> it = lineList.listIterator();

		while (it.hasNext()) {

			String str = (String) it.next();

			if (str.length() == 0 || str.charAt(0) != '[') {
				// System.out.println(str);
				continue;
			}

			String[] sp = str.split("] ", 3);

			String name = sp[0].substring(1);
			time.add(sp[1]);
			if (people1.getName().equals(name)) {
				people1.add(sp[2]);
			} else {
				people2.add(sp[2]);
			}
		}
	}

	public void print() {
		fileOutput.timePrint(time.getMap());
		fileOutput.peoplePrint(people1.getName(), people1.getMap());
		fileOutput.peoplePrint(people2.getName(), people2.getMap());
	}
}
