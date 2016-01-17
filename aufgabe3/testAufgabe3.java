package aufgabe3;

import java.util.List;

public class testAufgabe3 {
	
	public static void main(String[] args) {
	TxtFolderReader in = new TxtFolderReader ();
	List<String> train =in.readFolder(args[0]);
	TextClassification textcl =new TextClassification ();
	textcl.trainA(train);
	List<String> train2 =in.readFolder(args[1]);
	textcl.trainB(train2);
	List<String> test =in.readFolder(args[2]);
	textcl.creatCrit();
	double ok=0;
	/*for(String text:test){
		if(0==textcl.test(text))ok++;
	}
	System.out.println(ok/test.size());*/
	List<String> test2 =in.readFolder(args[3]);
	ok=0;
	for(String text:test2){
		if(1==textcl.test(text))ok++;
	}
	System.out.println(ok/test2.size());
	List<String> test3 =in.readFolder(args[4]);
	ok=0;
	for(String text:test3){
		if(0==textcl.test(text))ok++;
	}
	System.out.println(ok/test3.size());
	}
}
