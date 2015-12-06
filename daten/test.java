package daten;

import optimierung.Optimierung;
import verteilung.Verteilung;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Praktikas pr=new Praktikas();
		pr.generat(0,5,8);
		System.out.println(pr.einF.get(0).studId);
		Praktikas pr2 =pr.clone();
		System.out.println("länge liste 1 "+pr.einF.size());

		System.out.println("länge liste 2 "+pr.zweiF.size());

		System.out.println("länge liste 3 "+pr.dreiF.size());
	
		Verteilung ver=new Verteilung();
		ver.teileEin(pr);
		System.out.println("länge liste 1 "+pr2.einF.size());

		System.out.println("länge liste 2 "+pr2.zweiF.size());

		System.out.println("länge liste 3 "+pr2.dreiF.size());
		ver.teileEin(pr2);
		
		System.out.println("länge liste 1 "+pr.einF.size());

		System.out.println("länge liste 2 "+pr.zweiF.size());

		System.out.println("länge liste 3 "+pr.dreiF.size());

		System.out.println("Happyall pr1 "+pr.getHappyAll());
		System.out.println("Happyall pr2 "+pr2.getHappyAll());
		
		Optimierung op=new Optimierung();
		final long timeStart = System.currentTimeMillis(); 
		op.optimum(pr);
		 final long timeEnd = System.currentTimeMillis();
	     System.out.println("Verlaufszeit der ersten Optimierung: " + (timeEnd - timeStart) + " Millisek."); 
	     final long timeStart2 = System.currentTimeMillis();
		op.optimum(pr2);
		 final long timeEnd2 = System.currentTimeMillis();
	     System.out.println("Verlaufszeit der zweiten Optimierung: " + (timeEnd2 - timeStart2) + " Millisek."); 
		System.out.println("Happyall pr1 op "+pr.getHappyAll());
		System.out.println("Happyall pr2 op "+pr2.getHappyAll());
	}

}
