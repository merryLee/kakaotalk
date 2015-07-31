package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

	private Printer printer = new Printer();
	private Time time = new Time();

	private ArrayList<People> peopleList = new ArrayList<People>();
	private ArrayList<String> nameList = new ArrayList<String>();

	private String prevName;
	
	public Analyzer() {
	}

	public void start(List<String> lineList) {

		Iterator<String> it = lineList.listIterator();

		while (it.hasNext()) {

			String str = (String) it.next();

			if (str.length() == 0) { 		// 공백이면 continue;
				continue;
			} else if (isDate(str)) {		// 날짜면 continue;
				continue;
			} else if (str.length() != 0 && str.charAt(0) != '[') { 	// 줄바꿈되어 메시지만 있을 경우.
				addMessage(str, prevName);
			} else {						// '[이름] [시간] 메시지' 분리.
				distribute(str);
			}

		}
		
		print();
	}

	private boolean isDate(String data) {
		String pattern = "^[-]{15} (\\d{4})년 (\\d{1,2})월 (\\d{1,2})일 [일|월|화|수|목|금|토]요일 [-]{15}$";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(data);

		if (m.matches()) {
			return true;
		}
		return false;
	}

	private void distribute(String str) {

		String[] sp = str.split("] ", 3);

		String name = sp[0].substring(1);
		prevName = name;

		addTime(sp[1]);
		createPeople(name);
		addMessage(sp[2], name);

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
