package daten;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Praktikas {
	int anzahlStud =80;
	int anzPr = ((int)Math.round(anzahlStud/12.0d));
	List<Student> einF;
	List<Student> dreiF;
	List<Student> zweiF;
	Fach a= new Fach(anzPr);
	Fach b= new Fach(anzPr);
	Fach c= new Fach(anzPr);
	
	
	Praktikas(){
		
	}

	public void generat (){
		Random random = new Random();
		random.nextDouble();
		double zufall;
		int anzF=0;
		einF=new LinkedList<Student>();
		zweiF=new LinkedList<Student>();
		dreiF=new LinkedList<Student>();
		List<Student> ohneF =new LinkedList<Student>();
		
		/*
		 * Erzeugung aller Studierende
		 */
		for(int i =0;i<anzahlStud;i++){
			Student studt =new Student(i+1);
			studt.praktikas= new Praktikum[anzPr*3];
			einF.add(studt);
			/*
			 * Erzeugung der beziehungen der Studiernden
			 */
			for(int j =0;j<i;j++){
				zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
				studt.beziehungen.put(j+1, zufall);
				einF.get(j).beziehungen.put(i+1, zufall);
			}
		}
		/*
		 * Verteilung der Fächer
		 */
		for(Student stud :einF){
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.8){
				anzF++;
				stud.faecher[0]= a;;
			}
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.9){
				anzF++;
				stud.faecher[1]= b;;
			}
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.85){
				anzF++;
				stud.faecher[2]= c;;
			}
			switch (anzF){
			case  2: zweiF.add(stud);break; 
			case  3: dreiF.add(stud);break;
			case  0: ohneF.add(stud);break;
			default : break;
			}
			anzF=0;
		}
		einF.removeAll(ohneF);
		einF.removeAll(zweiF);
		einF.removeAll(dreiF);
		
		
		
	}
	public Praktikas clone(){
		Praktikas out = new Praktikas();
		out.einF=new LinkedList<Student>();
		for(Student stud :this.einF){
			Student help=stud.clone();
			if(stud.faecher[0]!=null) help.faecher[0]=a;
			if(stud.faecher[1]!=null) help.faecher[1]=b;
			if(stud.faecher[2]!=null) help.faecher[2]=c;
			out.einF.add(help);
		}
		out.zweiF=new LinkedList<Student>();
		for(Student stud :this.zweiF){
			Student help=stud.clone();
			if(stud.faecher[0]!=null) help.faecher[0]=a;
			if(stud.faecher[1]!=null) help.faecher[1]=b;
			if(stud.faecher[2]!=null) help.faecher[2]=c;
			out.zweiF.add(help);
		}
		out.dreiF=new LinkedList<Student>();
		for(Student stud :this.dreiF){
			Student help=stud.clone();
			if(stud.faecher[0]!=null) help.faecher[0]=a;
			if(stud.faecher[1]!=null) help.faecher[1]=b;
			if(stud.faecher[2]!=null) help.faecher[2]=c;
			out.dreiF.add(help);
		}
		return out;
		
	}

}
