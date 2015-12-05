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
	Fach a;
	Fach b;
	Fach c;
	private int startA;
	private int startB;
	private int startC;
	private int countStudtA;
	private int countStudtB;
	private int countStudtC;
	public List<Student> getEinF() {
		return einF;
	}


	public List<Student> getDreiF() {
		return dreiF;
	}


	public List<Student> getZweiF() {
		return zweiF;
	}


	public Fach getA() {
		return a;
	}


	public Fach getB() {
		return b;
	}


	public Fach getC() {
		return c;
	}

	public double getHappyAll(){
		
		return a.getHappy()+b.getHappy()+c.getHappy();
		
	}

	public void generat (int startA,int startB,int startC){
		this.startA=startA;
		this.startB=startB;
		this.startC=startC;
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
		 a= new Fach();
		 b= new Fach();
		 c= new Fach();
		 int countA=0;
		 int countB=0;
		 int countC=0;
		for(Student stud :einF){
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.8){
				anzF++;
				stud.faecher[0]= a;
				countA++;
			}
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.9){
				anzF++;
				stud.faecher[1]= b;
				countB++;
			}
			zufall = Math.round(100.0 * random.nextDouble()) / 100.0;
			if(zufall<0.85){
				anzF++;
				stud.faecher[2]= c;
				countC++;
			}
			switch (anzF){
			case  2: zweiF.add(stud);break; 
			case  3: dreiF.add(stud);break;
			case  0: ohneF.add(stud);break;
			default : break;
			}
			anzF=0;
		}
		a.generatePr(countA,startA);
		b.generatePr(countB,startB);
		c.generatePr(countC,startC);
		countStudtA=countA;
		countStudtB=countB;
		countStudtC=countC;
		einF.removeAll(ohneF);
		einF.removeAll(zweiF);
		einF.removeAll(dreiF);
		
		
		
	}
	public Praktikas clone(){
		Praktikas out = new Praktikas();
		out.einF=new LinkedList<Student>();
		out.a=new Fach();
		out.b=new Fach();
		out.c=new Fach();
		out.a.generatePr(countStudtA, startA);
		out.b.generatePr(countStudtB, startB);
		out.c.generatePr(countStudtC, startC);
		for(Student stud :this.einF){
			Student help=stud.clone();
			if(stud.faecher[0]!=null) help.faecher[0]=out.a;
			if(stud.faecher[1]!=null) help.faecher[1]=out.b;
			if(stud.faecher[2]!=null) help.faecher[2]=out.c;
			out.einF.add(help);
		}
		out.zweiF=new LinkedList<Student>();
		for(Student stud :this.zweiF){
			Student help=stud.clone();
			if(stud.faecher[0]!=null) help.faecher[0]=out.a;
			if(stud.faecher[1]!=null) help.faecher[1]=out.b;
			if(stud.faecher[2]!=null) help.faecher[2]=out.c;
			out.zweiF.add(help);
		}
		out.dreiF=new LinkedList<Student>();
		for(Student stud :this.dreiF){
			Student help=stud.clone();
			if(stud.faecher[0]!=null) help.faecher[0]=out.a;
			if(stud.faecher[1]!=null) help.faecher[1]=out.b;
			if(stud.faecher[2]!=null) help.faecher[2]=out.c;
			out.dreiF.add(help);
		}
		return out;
		
	}

}
