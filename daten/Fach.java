package daten;

public class Fach {
	Praktikum[] praktikas;

	public Fach() {
		// TODO Auto-generated constructor stub
		
	}
	public void generatePr (int a){
		praktikas = new Praktikum[(int) Math.round(a/12.0+0.5)];
		for (int i = 0; i < praktikas.length; i++) {
			praktikas[i] = new Praktikum(this, i);
		}
	}

	public Praktikum[] getPraktikas() {
		return praktikas;
	}
}
