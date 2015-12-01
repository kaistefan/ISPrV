package daten;

import verteilung.Verteilung;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Praktikas pr=new Praktikas();
		pr.generat();
		System.out.println(pr.einF.get(0).studId);
		Praktikas pr2 =pr.clone();
		Student stud=pr2.einF.get(0);
		stud.studId=99;
		/*System.out.println(pr.zweiF.get(0).faecher[0]);
		System.out.println(pr.zweiF.get(0).faecher[1]);
		System.out.println(pr.zweiF.get(0).faecher[2]);
		System.out.println(pr.einF.get(0).studId);
		System.out.println(stud.studId);
		System.out.println(pr.einF.size());

		System.out.println(pr.zweiF.size());

		System.out.println(pr.dreiF.size());*/
		Verteilung ver=new Verteilung();
		ver.teileEin(pr);
		stud =pr.a.praktikas[0].studenten.get(0);
		System.out.println(stud.praktikas[0]);
		System.out.println(stud.praktikas[1]);
		System.out.println(stud.praktikas[2]);
		System.out.println("länge liste 1"+pr.einF.size());

		System.out.println("länge liste 1"+pr.zweiF.size());

		System.out.println("länge liste 1"+pr.dreiF.size());
	}

}
