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

		/* wenn kein PLatz gefunden wird, dann...???
		 * try catch versuchen, da array out of bound exception wenn kein platz gefunden wird
		 */
		while (!pras.getDreiF().isEmpty()) {
			stud = pras.getDreiF().get(1);
			int i = 0;

			// Fach A
			while (pras.getA().getPraktikas()[i].isFull()) {
				i++;
			}
			slots[0] = pras.getA().getPraktikas()[i];

			// Fach B
			i=0;
			while (pras.getB().getPraktikas()[i].isFull() || (slots[0].getId() == i)) {
				i++;
			}
			slots[1] = pras.getB().getPraktikas()[i];

			// Fach C
			i=0;
			while (pras.getC().getPraktikas()[i].isFull() || (slots[0].getId() == i) || (slots[1].getId() == i)) {
				i++;
			}
			slots[2] = pras.getC().getPraktikas()[i];

			stud.setPraktikas(slots);

			// Step speichern
			st = new Step(stud, pras.getDreiF());
			steps.add(st);
		}
		// 2 Fächer
		// woher krieg ich die Fächer die der Student belegt
		while (!pras.getZweiF().isEmpty()) {

		}
		
		// 1 Fach
		while (!pras.getZweiF().isEmpty()) {

		}
		return true;
	}
}
