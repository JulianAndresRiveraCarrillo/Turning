package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.management.openmbean.OpenDataException;

public class Main {

	public static void main(String[] args) {
		long init = System.currentTimeMillis();
		OpenData();
		
		
		long end = System.currentTimeMillis();
		long time = (end - init)/1000;
		System.out.println(time);
	}
	
	public static void OpenData() {
		File doc = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			doc = new File("data/prueba.txt");
			fr = new FileReader(doc);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				//System.out.println(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException f) {
			System.err.println(f.getMessage());
		} catch (IOException i) {
			System.err.println(i.getMessage());
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
