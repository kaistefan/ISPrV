package verteilung;

import java.util.LinkedList;
import java.util.Stack;

import daten.Praktikas;
import daten.Praktikum;
import daten.Student;

public class Verteilung {
	private Stack<Step> steps;

	public boolean teileEin(Praktikas pras) {
		Student stud;
		Step st;
		Praktikum[] slots = new Praktikum[3];
		stud = pras.getDreiF().get(1);
		int i = 0;
		
		// Fach A
		while (pras.getA().getPraktikas()[i].isFull()) {i++;}
		slots[0]=pras.getA().getPraktikas()[i];
		
		// Fach B
		while (pras.getB().getPraktikas()[i].isFull() || (slots[0].getId()==i)) {i++;}
		slots[1]=pras.getB().getPraktikas()[i];
		
		// Fach C
		while (pras.getC().getPraktikas()[i].isFull() || (slots[0].getId()==i) || (slots[1].getId()==i)) {i++;}
		slots[2]=pras.getC().getPraktikas()[i];
		
		stud.setPraktikas(slots);
		
		// Step speichern
		st = new Step(stud, pras.getDreiF());
		steps.add(st);

		// 2 F�cher
		//woher krieg ich die F�cher die der student belegt

		// 1 Fach

		return true;
	}
}
