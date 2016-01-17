package aufgabe3;

import java.util.List;

public class testAufgabe3 {
	
	public static void main(String[] args) {
	String krit="\\s.length  ,\\char ?,\\char :";
	
	TxtFolderReader in = new TxtFolderReader ();
	List<String> train =in.readFolder(args[0]);
	TextClassification textcl =new TextClassification ();
	textcl.trainA(train);
	List<String> train2 =in.readFolder(args[1]);
	textcl.trainB(train2);
	List<String> test =in.readFolder(args[2]);
	textcl.creatCriteria(krit);
	double testFilm=0;
	double testZeit=0;
	double evalFilm=0;
	double evalZeit=0;
	double ok=0;
	for(String text:test){
		if(0==textcl.test(text)){ok++;testFilm++;}
	}
	System.out.println("Film Test Richtig "+ok/test.size()+"%");
	List<String> test2 =in.readFolder(args[3]);
	ok=0;
	for(String text:test2){
		if(1==textcl.test(text)){ok++;testZeit++;}
	}
	System.out.println("Zeit Test Richtig "+ok/test2.size()+"%");
	System.out.println("Gesamt "+(testFilm+testZeit)/(test2.size()+test.size())+"%");
	List<String> test3 =in.readFolder(args[4]);
	ok=0;
	for(String text:test3){
		if(0==textcl.test(text)){ok++;evalFilm++;}
	}
	System.out.println("Film Richtig "+ok/test3.size()+"%");
	List<String> test4 =in.readFolder(args[5]);
	ok=0;
	for(String text:test4){
		if(1==textcl.test(text)){ok++;evalZeit++;}
	}
	System.out.println("Zeit Richtig "+ok/test4.size()+"%");
	System.out.println("eval Gesamt "+(evalFilm+evalZeit)/(test3.size()+test4.size())+"%");
	}
}
