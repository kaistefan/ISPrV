package pratikaverteilung;

import java.util.LinkedList;
import java.util.List;


public class Praktikum {
	Praktikum fach;
	List<Student> studenten;
	Praktikum(Praktikum fach){
		this.fach=fach;
		studenten=new LinkedList<Student>();
	}
	
}
