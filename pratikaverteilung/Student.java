package pratikaverteilung;

import java.util.HashMap;
import java.util.Map;

public class Student {
	int studId;
	Map<Integer,Double> beziehungen;
	Praktikum[] praktikas;
	Student(int id ){
		studId=id;
		beziehungen= new HashMap<Integer,Double>();
	}
}
