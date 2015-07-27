package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {

	private Printer printer = new Printer();
	private List<String> lineList;
	
	Time time = new Time();
	ArrayList<People> peopleList = new ArrayList<People>();
	ArrayList<String> nameList = new ArrayList<String>();

	public Analyzer(FileInput fileInput) {
		this.lineList = fileInput.read();
	}

	public void distribute() {

		Iterator<String> it = lineList.listIterator();

		while (it.hasNext()) {

			String str = (String) it.next();

			if (str.length() == 0 || str.charAt(0) != '[') {
				continue;
			}

			String[] sp = str.split("] ", 3);

			String name = sp[0].substring(1);
			
			addTime(sp[1]);
			createPeople(name);
			addMessage(sp[2], name);
		} // while
	}

	private void addTime(String sp1) {
		String t = sp1.substring(1, sp1.indexOf(":"));
		time.analyze(t);
	}

	private void createPeople(String name) {
		if (!nameList.contains(name)) {
			nameList.add(name);
			peopleList.add(new People(name));
		}
	}

	private void addMessage(String sp2, String name) {
		for (People people : peopleList) {
			if (people.getName().equals(name)) {
				people.analyze(sp2);
			}
		}
	}

	public void print() {
		printer.timePrint(time.getMap());

		for (People people : peopleList) {
			printer.peoplePrint(people.getName(), people.getMap());
		}
	}
}
