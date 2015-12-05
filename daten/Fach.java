package daten;

public class Fach {
	Praktikum[] praktikas;

	public Fach() {
		// TODO Auto-generated constructor stub
		
	}
	public void generatePr (int a,int b){
		praktikas = new Praktikum[(int) Math.round(a/12.0+0.5)];
		for (int i = 0; i < praktikas.length; i++) {
			praktikas[i] = new Praktikum(this, i+b);
		}
	}

	public Praktikum[] getPraktikas() {
		return praktikas;
	}
	public double getHappy(){
		double out=0;
		for(Praktikum pr:praktikas){
			out+=pr.happy;
		}
		return out;
		
	}
}
