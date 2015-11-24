package verteilung;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import daten.Praktikas;
import daten.Praktikum;
import daten.Student;

public class Verteilung {
	private Stack<Step> steps;

	public void stepBack() {
		if (!steps.isEmpty()) {
			Step step = steps.pop();
			for (Praktikum pr : step.studt.getPraktikas()) {
				pr.removeStudt(step.studt);
			}
			step.list.add(step.studt);
		}
	}

	public boolean teileEin(Praktikas pras) {
		Student stud;
		Step st;
		Praktikum[] slots = new Praktikum[3];
		steps = new Stack<Step>();
		Random random = new Random();
		List<Student> studenten;

		/*
		 * wenn kein PLatz gefunden wird, dann...??? try catch versuchen, da
		 * array out of bound exception wenn kein platz gefunden wird
		 */

		studenten = pras.getDreiF();
		while (!studenten.isEmpty()) {
			while (!studenten.isEmpty()) {
				stud = studenten.remove(random.nextInt(studenten.size()));
				int i = 0;

				// Fach A
				if (!(stud.getFaecher()[0] == null)) {
					while (pras.getA().getPraktikas()[i].isFull()) {
						i++;
					}
					slots[0] = pras.getA().getPraktikas()[i];
				}
				// Fach B
				if (!(stud.getFaecher()[1] == null)) {
					i = 0;
					while (pras.getB().getPraktikas()[i].isFull() || (slots[0].getId() == i)) {
						i++;
					}
					slots[1] = pras.getB().getPraktikas()[i];
				}
				// Fach C
				if (!(stud.getFaecher()[2] == null)) {
					i = 0;
					while (pras.getC().getPraktikas()[i].isFull() || (slots[0].getId() == i)
							|| (slots[1].getId() == i)) {
						i++;
					}
					slots[2] = pras.getC().getPraktikas()[i];
				}

				stud.setPraktikas(slots);
				slots[0].addStudt(stud);
				// Step speichern
				st = new Step(stud, studenten);
				steps.add(st);
			}
			if (pras.getDreiF().isEmpty()) studenten= pras.getZweiF();
			if (pras.getZweiF().isEmpty()) studenten= pras.getEinF();
		}
		return true;
	}
}
