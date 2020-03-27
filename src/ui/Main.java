package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Machine;

public class Main {
	
	static Machine m;
	
	private static boolean isNumeric(String s) {
		boolean num = true;
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			num = false;
		}
		return num;
	}
	public static void main(String[] args) throws IOException {
		long init = System.currentTimeMillis();
		OpenData();
		WriteData();
		
		long end = System.currentTimeMillis();
		long time = (end - init)/1000;
		System.out.println(time);
	}
	
	public static void OpenData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("data/prueba.txt")));
		String line = br.readLine();

		while (line != null) {
			System.out.println(line);
			machine(line);
			line = br.readLine();
		}
		
		machine(line);
		
		br.close();
	}
	
	public static void WriteData() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data/texto1.txt")));
		
		for (int i = 0; i <= 10; i++) {
			 bw.write("Linea " + i + "\n");
		}
		
		bw.close();
	}
	
	public static void machine(String args) {
		String[] order = args.split("", 3);
		int o = Integer.parseInt(order[0]);
		int c = Integer.parseInt(order[1]);
		char letter = ' ';
		
		if (isNumeric(order[2])) {
			letter = order[2].charAt(0);
		}
		
		if (o == 0) {
			read(c);
		}else if (o == 1) {
			m.addLetter(c, letter);
		}else {
			m.removeLetter(c);
		}
	}
	
	public static char read(int c) {
		char letter = m.readLetter(c);
		return letter;
	}
	
}
