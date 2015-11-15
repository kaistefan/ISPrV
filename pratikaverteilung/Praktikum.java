package pratikaverteilung;

import java.util.LinkedList;
import java.util.List;


public class Praktikum {
	int id;
	Fach fach;
	List<Student> studenten;
	Praktikum(Fach fach,int id){
		this.id=id;
		this.fach=fach;
		studenten=new LinkedList<Student>();
	}
	
}
