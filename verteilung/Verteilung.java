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
				if(pr!=null)pr.removeStudt(step.studt);
			}
			step.studt.setPraktikas(null);
			step.list.add(step.studt);
		}
	}

	public void teileEin(Praktikas pras) {
		Student stud;
		Step st;
		Praktikum[] slots = new Praktikum[3];
		steps = new Stack<Step>();
		Random random = new Random();
		random.nextInt();
		List<Student> studenten;
		int error = 0;
		int errorTotal =0;
		studenten = pras.getDreiF();
		while (!studenten.isEmpty()) {
			stud = studenten.remove(random.nextInt(studenten.size()));

			do  {
				error = 0;
				int i = 0;

				// Fach A
				if (stud.getFaecher()[0] != null) {
					while (i<pras.getA().getPraktikas().length&&pras.getA().getPraktikas()[i].isFull()) {
						i++;
					}
					if (i>=pras.getA().getPraktikas().length||pras.getA().getPraktikas()[i].isFull()) {
						error += 1;
					} else {
						slots[0] = pras.getA().getPraktikas()[i];
					}
				}
				// Fach B
				if (stud.getFaecher()[1] != null) {
					i = 0;
					while (i<pras.getB().getPraktikas().length&&
							(pras.getB().getPraktikas()[i].isFull() || (slots[0]!=null &&slots[0].getId() == i))) {
						i++;
					}
					if (i>=pras.getB().getPraktikas().length||pras.getB().getPraktikas()[i].isFull()) {
						error += 1;
					} else {
						slots[1] = pras.getB().getPraktikas()[i];
					}
				}
				// Fach C
				if (stud.getFaecher()[2] != null) {
					i = 0;
					while (i<pras.getC().getPraktikas().length&&
							(pras.getC().getPraktikas()[i].isFull() || (slots[0]!=null &&slots[0].getId() == i)
							|| (slots[1]!=null &&slots[1].getId() == i))) {
						i++;
					}
					if (i>=pras.getC().getPraktikas().length||pras.getC().getPraktikas()[i].isFull()) {
						error += 1;
					} else {
						slots[2] = pras.getC().getPraktikas()[i];
					}
				}
				if (error > 0) {
					stepBack();
				}
				if(error > 0)errorTotal++;
				if(errorTotal>1000000){
					break;
				}
			}while(error > 0);
			// Praktikas setzen
			if(errorTotal>1000000){
				break;
			}
			stud.setPraktikas(slots);
			if(slots[0]!=null)slots[0].addStudt(stud);
			if(slots[1]!=null)slots[1].addStudt(stud);
			if(slots[2]!=null)slots[2].addStudt(stud);
			slots=new Praktikum[3];
			// Step speichern
			st = new Step(stud, studenten);
			steps.add(st);

			if (pras.getDreiF().isEmpty())
				
				if (pras.getZweiF().isEmpty())
					studenten = pras.getEinF();
				else
				studenten = pras.getZweiF();
			else{
				studenten=pras.getDreiF();
			}
			
		}
	}
}
