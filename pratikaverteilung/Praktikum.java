package pratikaverteilung;

import java.util.LinkedList;
import java.util.List;


public class Praktikum {
	int id;
	double happy;
	Fach fach;
	List<Student> studenten;
	Praktikum(Fach fach,int id){
		this.id=id;
		this.fach=fach;
		happy=0.0;
		studenten=new LinkedList<Student>();
	}
	
	public void addStudt (Student studt){
		if(studenten.size()==0)studenten.add(studt);
		else{
			for(Student all:studenten){
				happy+= (studt.beziehungen.get(all)-0.5);
			}
			studenten.add(studt);
		}
	}
    public void removeStudt (Student studt){
		studenten.remove(studt);
		if(studenten.size()<=1)happy=0.0;
		else{
			for(Student all:studenten){
				happy-= (studt.beziehungen.get(all)-0.5);
			}
		}
	}
	
}
