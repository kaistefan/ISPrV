package pratikaverteilung;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Praktikas {
	int anzahlStud =80;
	int anzPr = ((int)Math.round(anzahlStud/12.0d))*3;
	List<Student> studierende;
	List<Student> dreiF;
	List<Student> zweiF;
	List<Student> fachA;
	List<Student> fachB;
	List<Student> fachC;
	Fach a;
	Fach b;
	Fach c;
	
	Praktikas(){
		Random random = new Random();
		random.nextDouble();
		double zufall;
		int anzF=0;
		studierende=new LinkedList<Student>();
		fachA=new LinkedList<Student>();
		fachB=new LinkedList<Student>();
		fachC=new LinkedList<Student>();
		zweiF=new LinkedList<Student>();
		dreiF=new LinkedList<Student>();
		List<Student> ohneF =new LinkedList<Student>();
		/*
		 * Erzeugung aller Studierende
		 */
		for(int i =0;i<anzahlStud;i++){
			Student studt =new Student(i+1);
			studt.praktikas= new Praktikum[anzPr];
			studierende.add(studt);
			/*
			 * Erzeugung der beziehungen der Studiernden
			 */
			for(int j =0;j<i;j++){
				zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
				studt.beziehungen.put(j+1, zufall);
				studierende.get(j).beziehungen.put(i+1, zufall);
			}
		}
		/*
		 * Verteilung der Fächer
		 */
		for(Student stud :studierende){
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.8){
				anzF++;
				fachA.add(stud);
			}
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.9){
				anzF++;
				fachB.add(stud);
			}
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.85){
				anzF++;
				fachC.add(stud);
			}
			switch (anzF){
			case  2: zweiF.add(stud);break; 
			case  3: dreiF.add(stud);break;
			case  0: ohneF.add(stud);break;
			default : break;
			}
			anzF=0;
		}
		studierende.removeAll(ohneF);
		
		
		
	}
}
