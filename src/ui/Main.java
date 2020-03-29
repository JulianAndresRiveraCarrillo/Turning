package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Machine;

public class Main {
	
	static Machine m = new Machine();
	
	public static void main(String[] args) throws IOException {
		long init = System.currentTimeMillis();
		System.out.println("empezamos");
		openData();
		
		long end = System.currentTimeMillis();
		long time = (end - init)/1000;
		System.out.println(time);
	}
	
	public static void openData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("data/prueba.txt")));
		String line = br.readLine();

		while (line != null) {
			System.out.println("machine");
			machine(line);
			line = br.readLine();
		}
		//System.out.println("machine");
		//machine(line);
		
		br.close();
	}
	
	public static void writeData(char letter) throws IOException {
		File data = new File("data/archivo_nuevo.txt");
		FileWriter fw = new FileWriter(data,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		char write = letter;
		if(write != ' ') {
			fw.write(write + "\n");
		}
		
		bw.close();
	}
	
	public static void machine(String args) throws IOException {
		ArrayList<Character> orders = new ArrayList<Character>();
		ArrayList<Integer>order = new ArrayList<Integer>();
		int or = 0;
		int cb = 0;
		int j = 0;
		char letter;
		for (int i = 0; i < args.length(); i++) {
			
			char temp = args.charAt(i);
			if (isNumeric(temp)) {
				order.add(Integer.parseInt(String.valueOf(temp)));
			}else {
				orders.add(temp);
			}
		}
		for (int i = 0; i < order.size(); i++) {
			char aux = ' ';
			if (i == 0) {
				or = order.get(i+1);
				cb = order.get(i);
			}else {
				or = order.get(i+2);
				cb = order.get(i+1);
			}
			if (j < orders.size()) {

				aux = orders.get(j);
				j++;
			}
			letter = aux;
			System.out.println("Action");
			actions(or, cb, letter);
		}
	}
	
	public static void actions(int act, int punt, char let) throws IOException {
		/*System.out.println(act);
		System.out.print(punt);
		System.out.println(let);*/
		if (act == 0) {
			read(punt);
			System.out.println("write");
		}else if (act == 1) {
			System.out.println("Add");
			m.addLetter(punt, let);
		}else {
			System.out.println("remove");
			m.removeLetter(punt);
		}
	}
	public static char read(int c) throws IOException {
		char letter = m.readLetter(c);
		writeData(letter);
		return letter;
	}
	
	public static boolean isNumeric(char temp) {
		boolean num = true;
		try {
			Integer.parseInt(String.valueOf(temp));
		} catch (NumberFormatException e) {
			num = false;
		}
		return num;
	}
	
}
