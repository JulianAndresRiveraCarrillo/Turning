package model;

public class Machine {

	private Letter C0;
	private Letter C1;
	private Letter C2;
	
	private Letter firstLetter;
	
	public Machine() {
		C0 = null;
		C1 = null;
		C2 = null;
	}
	
	public void Lenght() {
		C2 = firstLetter;
		C1 = firstLetter;
		int i = 0;
		while (firstLetter != null && C2.getNextL() != null) {
			i++;
			C2 = C2.getNextL();
		}
		int min = 0;
		int max = i;
		int med = (min+max)/2;
		int cont = 0;
		while (cont <= med ) {
			C1 = C1.getNextL();
		}
	}
	public void addLetter(int c, char letter) {
		Letter L = new Letter(letter);
		Letter temp = null;
		if (firstLetter == null) {
			firstLetter = L;
			C0 = firstLetter;
			C1 = firstLetter;
			C2 = firstLetter;
		}else {
			if(c == 0) {
				temp = firstLetter;
				C0 = L;
				firstLetter = L;
				firstLetter.setNextL(temp);
				temp.setPrevL(firstLetter);
			}else if(c == 1 ) {
				temp = C1;
				C1= L;
				C1.setNextL(temp.getNextL());
				C1.setPrevL(temp);
				temp.setNextL(C1);
			} else if(c == 2) {
				temp = C2;
				C2 = L;
				temp.setNextL(C2);
				C2.setNextL(null);
				C2.setPrevL(temp);
			}
		}
	}
	
	public void removeLetter(int c) {
		Letter temp = null;
		if (firstLetter != null) {
			if (c == 0) {
				firstLetter = C0.getNextL();
				C0 = firstLetter;
			}else if (c == 1) {
				temp = C1.getPrevL();
				temp.setNextL(C1.getNextL());
				C1.getNextL().setPrevL(temp);
				Lenght();
			}else if (c == 2) {
				temp = C2.getPrevL();
				C2 = temp;
				C2.setNextL(null);
			}
		}
	}
	
	
	
	
	
}