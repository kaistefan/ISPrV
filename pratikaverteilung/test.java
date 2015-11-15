package pratikaverteilung;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Praktikas pr=new Praktikas();
		pr.generat();
		System.out.println(pr.einF.get(0).studId);
		Praktikas pr2 =pr.clone();
		Student stud=pr2.einF.get(0);
		stud.studId=99;
		System.out.println(pr.einF.get(0).studId);
		System.out.println(stud.studId);
		System.out.println(pr.einF.size());

		System.out.println(pr.zweiF.size());

		System.out.println(pr.dreiF.size());
		
	}

}
