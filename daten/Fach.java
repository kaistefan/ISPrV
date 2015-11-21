package daten;

public class Fach {
	Praktikum[] praktikas;

	public Fach(int anzPr) {
		// TODO Auto-generated constructor stub
		praktikas = new Praktikum[anzPr];
		for (int i = 0; i < praktikas.length; i++) {
			praktikas[i] = new Praktikum(this, i);
		}
	}

	public Praktikum[] getPraktikas() {
		return praktikas;
	}
}
