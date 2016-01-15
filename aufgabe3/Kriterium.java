package aufgabe3;

import java.util.HashMap;

public class Kriterium {
	Token kriterium;
	HashMap<Integer,Integer> resultsA;
	HashMap<Integer,Integer> resultsB;
	
	public Kriterium(Token t){
		kriterium=t;
		resultsA = new HashMap<Integer,Integer>();
		resultsB = new HashMap<Integer,Integer>();
	}

	public HashMap<Integer, Integer> getResultsA() {
		return resultsA;
	}

	public void setResultsA(HashMap<Integer, Integer> resultsA) {
		this.resultsA = resultsA;
	}

	public HashMap<Integer, Integer> getResultsB() {
		return resultsB;
	}

	public void setResultsB(HashMap<Integer, Integer> resultsB) {
		this.resultsB = resultsB;
	}

	public Token getKriterium() {
		return kriterium;
	}
}
