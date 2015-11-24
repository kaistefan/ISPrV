package daten;

import java.util.HashMap;
import java.util.Map;

public class Student {
	int studId;
	Map<Integer, Double> beziehungen;
	Fach[] faecher = new Fach[3];
	Praktikum[] praktikas;

	Student(int id) {
		studId = id;
		beziehungen = new HashMap<Integer, Double>();
	}
<<<<<<< HEAD
	public boolean isfree(int i){
		boolean free=true;
		for(Praktikum pr :praktikas){
			if(pr.id==i)return false;
		}
		
		return free;
	}
=======
	
>>>>>>> ac81ecd9e550e9323d83f56d0a8cdc97899345bb
	
	public Praktikum[] getPraktikas() {
		return praktikas;
	}


	public void setPraktikas(Praktikum[] praktikas) {
		this.praktikas = praktikas;
	}


	public Student clone() {
		Student out = new Student(studId);
		out.beziehungen = this.beziehungen;
		out.praktikas = this.praktikas.clone();
		return out;
	}
	
	public Fach[] getFaecher(){
		return faecher;
	}

}
