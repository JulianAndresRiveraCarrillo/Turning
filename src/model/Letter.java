package model;

public class Letter {
	
	private char letter;
	
	private Letter nextL;
	private Letter prevL;
	
	public Letter(char letter) {
		this.letter = letter;
		nextL = null;
		prevL = null;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public Letter getNextL() {
		return nextL;
	}

	public void setNextL(Letter nextL) {
		this.nextL = nextL;
	}

	public Letter getPrevL() {
		return prevL;
	}

	public void setPrevL(Letter prevL) {
		this.prevL = prevL;
	}

	public char toChar() {
		return letter;
	}
	
	

}
