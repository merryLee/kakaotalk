package com.cdg.kakaotalk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInput {

	private List<String> list = new ArrayList<String>();
	private String inputFile;

	public FileInput(String inputFile) {
		this.inputFile = inputFile;
	}

	public List<String> read() {

		try {
			FileReader in = new FileReader(inputFile);
			BufferedReader bin = new BufferedReader(in);
			String line;

			while ((line = bin.readLine()) != null) {
				list.add(line);
			}
			in.close();
			bin.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

}
