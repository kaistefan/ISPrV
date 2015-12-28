package daten;

import optimierung.Optimierung;
import verteilung.*;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			final long timeStart4 = System.currentTimeMillis();
		Praktikas pr=new Praktikas();
		pr.generat(0,2,5);
		System.out.println(pr.einF.get(0).studId);
		Praktikas pr2 =pr.clone();
		Praktikas pr3 =pr.clone();
		System.out.println("länge liste 1 "+pr.einF.size());

		System.out.println("länge liste 2 "+pr.zweiF.size());

		System.out.println("länge liste 3 "+pr.dreiF.size());
	
		Verteilung ver=new Verteilung();
		
			ver.teileEin(pr);
		
		System.out.println("länge liste 1 "+pr2.einF.size());

		System.out.println("länge liste 2 "+pr2.zweiF.size());

		System.out.println("länge liste 3 "+pr2.dreiF.size());
		
			ver.teileEin(pr2);
			ver.teileEin(pr3);
			System.out.println("anzahl a" + pr.countStudtA);
			for(Praktikum a :pr.a.praktikas){
		    	 System.out.println(a);
		    	
		     }
			for(Praktikum a :pr.b.praktikas){
		    	 System.out.println(a);
		    	
		     }
			for(Praktikum a :pr.c.praktikas){
		    	 System.out.println(a);
		    	
		     }
		System.out.println("anzahl nicht verteilter studeten"+(pr.dreiF.size()+pr.zweiF.size()+pr.einF.size()));
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
	     final long timeStart3 = System.currentTimeMillis();
			op.optimum(pr3);
			 final long timeEnd3 = System.currentTimeMillis();
		     System.out.println("Verlaufszeit der zweiten Optimierung: " + (timeEnd3 - timeStart3) + " Millisek."); 
		System.out.println("Happyall pr1 op "+pr.getHappyAll());
		System.out.println("Happyall pr2 op "+pr2.getHappyAll());

		System.out.println("Happyall pr3 op "+pr3.getHappyAll());
		final long timeEnd4 = System.currentTimeMillis();
	     System.out.println("Verlaufszeit der zweiten Optimierung: " + (timeEnd4 - timeStart4) + " Millisek.");
	     System.out.println(pr.countStudtA);
	     for(Praktikum a :pr.a.praktikas){
	    	 System.out.println(a);
	    	 for(Student std:a.studenten){
	    		 System.out.println(std);
	    		
	    		 
	    	 }
	     }
		} catch (SolutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
