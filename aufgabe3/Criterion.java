package aufgabe3;


public class Criterion {
	String typ;
	String item;
	Double [] a;
	Double [] b;
	
	/**
	 * 
	 * @param typ Der Typ des Kriterium 
	 * @param item Kriterium
	 * @param a Werte der Kategorie A
	 * @param b Werte der Kategorie B
	 */
	public Criterion(String typ,String item,Double [] a,Double [] b) {
		// TODO Auto-generated constructor stub
		this.typ=typ;
		this.item=item;
		this.a=a;
		this.b=b;
		sort(a);
		sort(b);
		
	}
	
	/**
	 * Sortiert das das Array vom kleinsten zum groeﬂten Wert.
	 * @param s zu sortierende Array
	 */
	private void sort(Double [] s){
		 for (int n=s.length; n>1; n=n-1){
			    for (int i=0; i<n-1; i=i+1){
			      if (s[i] > s[i+1]){
			    	  double temp = s[i];
			    	  s[i]=s[i+1];
			    	  s[i+1]=temp;
			      } // ende if
			    } // ende innere for-Schleife
			  } // ende ‰uﬂere for-Schleife
	}
	
	/**
	 * gibt die Wahrscheinlichkeiten der Zugehoerigkeit zu den beiden Kategorien  
	 * @param num  das vorkommen des Kriterium 
	 * @return die Wahrscheinlichkeiten
	 */
	Double[]test(Double num){
		if(num == null)num=0.0;
		Double[] out={0.0,0.0};
		Double size =(a[a.length-1]-a[0])/3;
		 if(num<=size){
			 out[0]=(double) (numberIn( 0.0,size,a)/a.length);
		 }
		 else{
			 if(num<=size*2){
			 out[0]=(double) (numberIn(size,size*2,a)/a.length);
			 }
			 else{		 
					 out[0]=(double) (numberIn(size*3,Double.MAX_VALUE,a)/a.length); 
				 }
			 }
		  size =(b[b.length-1]-a[0])/3;
		  if(num<=size){
				 out[1]=(double) (numberIn( 0.0,size,b)/b.length);
			 }
			 else{
				 if(num<=size*2){
				 out[1]=(double) (numberIn(size,size*2,b)/b.length);
				 }
				 else{					
					 out[1]=(double) (numberIn(size*3,Double.MAX_VALUE,b)/b.length);		 
					 }
				 }
		 return out;
	}
	
	/**
	 * Zaehlt das vorkommen der Werte zwischen min und max.
	 * @param min startwert
	 * @param max endwert
	 * @param a das Array
	 * @return Haeufigkeit 
	 */
	 private double numberIn(Double min,Double max,Double[]a){
		 double out=0.0;
		 for(int i =0;i<a.length;i++){
			 if(a[i]>=min&&a[i]<=max){
				 out++;
			 }
		 }	 
		 return out; 
	 }


}
